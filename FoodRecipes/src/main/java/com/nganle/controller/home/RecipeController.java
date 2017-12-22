package com.nganle.controller.home;

import static com.nganle.support.constant.Constant.ATTRIBUTE_NAME.CURRENT_PAGE;
import static com.nganle.support.constant.Constant.ATTRIBUTE_NAME.DISPLAY_PAGE;
import static com.nganle.support.constant.Constant.ATTRIBUTE_NAME.FISRT_PAGE;
import static com.nganle.support.constant.Constant.ATTRIBUTE_NAME.LAST_PAGE;
import static com.nganle.support.constant.Constant.ATTRIBUTE_NAME.LIST_RECIPE;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nganle.dto.CommentDTO;
import com.nganle.dto.KindCateBasicDTO;
import com.nganle.dto.MaterialSerchDTO;
import com.nganle.dto.RecipeCateSearchDTO;
import com.nganle.dto.RecipeDetailDTO;
import com.nganle.dto.RecipeTopViewDTO;
import com.nganle.dto.TopNewRecipeDTO;
import com.nganle.entity.Comment;
import com.nganle.entity.KindOfCate;
import com.nganle.entity.Material;
import com.nganle.entity.Recipe;
import com.nganle.entity.RecipeCategory;
import com.nganle.entity.Step;
import com.nganle.entity.User;
import com.nganle.service.CommentService;
import com.nganle.service.KindOfCateService;
import com.nganle.service.MaterialService;
import com.nganle.service.RecipeCategoryService;
import com.nganle.service.RecipeService;
import com.nganle.service.UserService;
import com.nganle.support.EntitySupport;
import com.nganle.support.constant.Constant;
import com.nganle.support.constant.ResultView;
import com.nganle.support.util.Utils;

@Controller
@RequestMapping("/recipe")
public class RecipeController {

	@Autowired
	private RecipeService recipeService;
	@Autowired
	private KindOfCateService kindOfCateService;
	@Autowired
	private RecipeCategoryService cateService;
	@Autowired
	private CommentService commentService;
	@Autowired
	private UserService userService;
	@Autowired
	private MaterialService materialService;

	@RequestMapping("/create-recipe")
	public String createRecipe() {
		return "home.create-recipe";
	}

	@RequestMapping("/detail")
	public String viewDetail(@RequestParam("id") int id, ModelMap model, HttpServletRequest request) {
		Recipe recipe = recipeService.getById(id);
		List<KindOfCate> kinds = kindOfCateService.listAll();
		List<Step> listStep = Step.toListStep(recipe.getContent());
		List<RecipeCategory> cates = cateService.listAll();
		List<Recipe> recipeSuggest = recipeService.searchByMaterial(recipe.getMaterialIds(), 5);
		List<Comment> comments = commentService.getByRecipeId(id);
		List<Integer> userIds = EntitySupport.getListUserIdFromComments(comments);
		List<User> users = userService.findInList(userIds);
		model.addAttribute(Constant.ATTRIBUTE_NAME.LIST_KIND_CATE,
				KindCateBasicDTO.toListDTOFooter(kinds, cates, 4, 7));
		recipeService.increaseView(id);
		model.addAttribute(Constant.ATTRIBUTE_NAME.RECIPE_DETAIL, RecipeDetailDTO.toRecipeDTO(recipe, listStep));
		model.addAttribute(Constant.ATTRIBUTE_NAME.RECIPE_DETAIL_SUGGEST, RecipeTopViewDTO.toListDTO(recipeSuggest));
		model.addAttribute(Constant.ATTRIBUTE_NAME.LIST_COMMENT, CommentDTO.toListDTO(comments, users));
		return ResultView.RECIPE.RECIPE_DETAIL;
	}

	@RequestMapping(value = "/doComment", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public CommentDTO doCommnet(@RequestBody String dataComment, HttpServletRequest request) {
		User commentUser = (User) Utils.getSession(request.getSession(), Constant.SESSION_NAME.USER_SESSION);
		Comment comment = new Comment();
		if (commentUser == null) {
			return new CommentDTO("usernull");
		}
		JSONParser parser = new JSONParser();
		try {
			JSONObject sentComment = (JSONObject) parser.parse(dataComment);
			String content = (String) sentComment.get("content");
			String recipeIdStr = (String) sentComment.get("recipeId");
			int recipeId = Integer.parseInt(recipeIdStr);
			comment.setRecipeId(recipeId);
			comment.setContent(content);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		comment.setUserId(commentUser.getId());
		commentService.create(comment);
		return CommentDTO.toDTO(comment, commentUser);
	}

	@RequestMapping("/search")
	public String search(@RequestParam(value = "data", required = false, defaultValue = "") String data,
						 @RequestParam(value = "kind", required = false, defaultValue = "-1") int kind,
						 @RequestParam( value = "page", required = false, defaultValue = "1") int page,
						 ModelMap model) {
		List<RecipeCategory> cates = cateService.listAll();
		List<RecipeCateSearchDTO> listCate = RecipeCateSearchDTO.toListDTO(cates);
		List<Material> materials = materialService.listAll();
		List<MaterialSerchDTO> listMaterial = MaterialSerchDTO.toListDTO(materials);
		if (data.isEmpty()) {
			kind = -1;
		}
		List<Recipe> recipes  = new ArrayList<Recipe>();
		if (kind == 1) {
			String[] cateIds = data.split("@");
			List<String> listRecipeCate = Utils.toListRecipeCate(cateIds);
			recipes = recipeService.searchByCate(listRecipeCate);
			EntitySupport.checkedCate(listCate, cateIds);
			model.addAttribute(Constant.ATTRIBUTE_NAME.DATA_BUFFER, data);
		} else if (kind == 2) {
			List<Integer> materialIds = Utils.toListCateId(data.split("@"));
			recipes = recipeService.searchByMaterial(materialIds, 1000);
			List<String> titles = EntitySupport.checkedMaterial(listMaterial, materialIds);
			model.addAttribute(Constant.ATTRIBUTE_NAME.lIST_MATERIAL_TITLE, titles);
			model.addAttribute(Constant.ATTRIBUTE_NAME.DATA_BUFFER, data);
		} else if (kind == 3) {
			recipes = recipeService.searchByTitle(data);
			model.addAttribute(Constant.ATTRIBUTE_NAME.SEARCH_KEY,data);
		}

		if (kind == -1) {
			recipes = recipeService.listAll();
		}
		List<TopNewRecipeDTO> listDTO = TopNewRecipeDTO.toListDTO(recipes);
		List<List<TopNewRecipeDTO>> pageList = TopNewRecipeDTO.toPageList(listDTO);
		if(pageList.size() != 0) {
			model.addAttribute(LIST_RECIPE, pageList.get(page - 1));
			model.addAttribute(DISPLAY_PAGE, Utils.getPageToDisplay(pageList.size(), page));
			model.addAttribute(CURRENT_PAGE, page);
			model.addAttribute(FISRT_PAGE, 1);
			model.addAttribute(LAST_PAGE, pageList.size());
		}
		model.addAttribute(Constant.ATTRIBUTE_NAME.LIST_RECIPE_CATE, listCate);
		model.addAttribute(Constant.ATTRIBUTE_NAME.KIND, kind);
		model.addAttribute(Constant.ATTRIBUTE_NAME.LIST_MATERIAL, listMaterial);
		return ResultView.RECIPE.SEARCH;
	}

}
