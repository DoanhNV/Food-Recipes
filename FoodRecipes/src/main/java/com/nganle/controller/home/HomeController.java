package com.nganle.controller.home;

import static com.nganle.support.constant.Constant.ATTRIBUTE_NAME.CURRENT_PAGE;
import static com.nganle.support.constant.Constant.ATTRIBUTE_NAME.DISPLAY_PAGE;
import static com.nganle.support.constant.Constant.ATTRIBUTE_NAME.FISRT_PAGE;
import static com.nganle.support.constant.Constant.ATTRIBUTE_NAME.LAST_PAGE;
import static com.nganle.support.constant.Constant.ATTRIBUTE_NAME.LIST_RECIPE;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nganle.dto.KindCateBasicDTO;
import com.nganle.dto.MaterialDTO;
import com.nganle.dto.RecipeCateForHomeDTO;
import com.nganle.dto.RecipeDTO;
import com.nganle.dto.RecipeTopViewDTO;
import com.nganle.dto.SlideDTO;
import com.nganle.dto.TipDTO;
import com.nganle.dto.TipForHomeDTO;
import com.nganle.dto.TopNewRecipeDTO;
import com.nganle.dto.UserForHomeDTO;
import com.nganle.dto.UserProfileDTO;
import com.nganle.entity.KindOfCate;
import com.nganle.entity.Material;
import com.nganle.entity.Recipe;
import com.nganle.entity.RecipeCategory;
import com.nganle.entity.Tip;
import com.nganle.entity.User;
import com.nganle.service.KindOfCateService;
import com.nganle.service.MaterialService;
import com.nganle.service.RecipeCategoryService;
import com.nganle.service.RecipeService;
import com.nganle.service.TipService;
import com.nganle.service.UserService;
import com.nganle.support.EntitySupport;
import com.nganle.support.constant.Constant;
import com.nganle.support.constant.ResultView;
import com.nganle.support.constant.SQLInfo;
import com.nganle.support.util.DateFormator;
import com.nganle.support.util.Utils;

@Controller
public class HomeController {
	@Autowired
	private RecipeService recipeService;
	@Autowired
	private RecipeCategoryService recipeCateService;
	@Autowired
	private UserService userService;
	@Autowired
	private MaterialService materialService;
	@Autowired
	private TipService tipService;
	@Autowired
	private KindOfCateService kindOfCateService;
	@Autowired
	private RecipeCategoryService cateService;

	@RequestMapping("/")
	public String loadIndex() {
		return Utils.redirect("/home/index");
	}

	@RequestMapping("/home/index")
	public String loadHome(ModelMap model,HttpServletRequest request) {
		List<Recipe> slide = recipeService.getSlide();
		List<Recipe> topNewRecipe = recipeService.getTopNews(6);
		List<Recipe> topViews = recipeService.getTopViews(4);
		List<RecipeCategory> recipeCates = recipeCateService.listAll();
		List<Material> materials = materialService.getTopLimit(36, SQLInfo.FIELD_CREATE_TIME,
				Constant.SQL_CHARACTER.DESC);
		List<User> user = userService.getTopOrder(6, SQLInfo.USER.FIELD_RECIPE_SAVE_IDS, Constant.SQL_CHARACTER.DESC);
		List<Tip> tips = tipService.getTopLimit(8, SQLInfo.FIELD_CREATE_TIME, Constant.SQL_CHARACTER.DESC);
		List<KindOfCate> kinds = kindOfCateService.listAll();
		List<RecipeCategory> cates = cateService.listAll();
		Utils.setSession(request.getSession(), Constant.SESSION_NAME.FOOTER_SESSION, KindCateBasicDTO.toListDTOFooter(kinds, cates, 4, 7));
		Utils.setSession(request.getSession(), Constant.SESSION_NAME.MENU_SESSION, EntitySupport.LIST_MENU);
		model.addAttribute(Constant.ATTRIBUTE_NAME.RECIPE_CATE, RecipeCateForHomeDTO.toListDTO(recipeCates, 12));
		model.addAttribute(Constant.ATTRIBUTE_NAME.SLIDE, SlideDTO.toListDTO(slide));
		model.addAttribute(Constant.ATTRIBUTE_NAME.TOP_RECIPE, RecipeTopViewDTO.toListDTO(topViews));
		model.addAttribute(Constant.ATTRIBUTE_NAME.TOP_NEW_RECIPE, TopNewRecipeDTO.toListDTO(topNewRecipe));
		model.addAttribute(Constant.ATTRIBUTE_NAME.LIST_USER, UserForHomeDTO.toListDTO(user));
		model.addAttribute(Constant.ATTRIBUTE_NAME.LIST_MATERIAL, MaterialDTO.toListDTO(materials));
		model.addAttribute(Constant.ATTRIBUTE_NAME.LIST_TIP, TipForHomeDTO.toListDTO(tips));
		return ResultView.HOME.INDEX;
	}

	@RequestMapping("/user/profile")
	public String user(@RequestParam("id") int id,
			@RequestParam(value = "page", required = false, defaultValue = "1") int page, ModelMap model,
			@RequestParam(value = "kind_cate", required = false, defaultValue = "1") int kind) {
		User user = userService.getById(id);
		UserProfileDTO userDTO = UserProfileDTO.toDTO(user);
		if (kind == 1) {
			List<String> recipeSavedIds = user.getRecipeSavedIds();
			List<Recipe> recipes = recipeService.searchByListId(Utils.toSqlInList(recipeSavedIds));
			List<RecipeDTO> listDTDO = RecipeDTO.toListDTDO(recipes);
			List<List<RecipeDTO>> pageList = RecipeDTO.toPageList(listDTDO);
			if(pageList.size() != 0) {
				model.addAttribute(LIST_RECIPE, pageList.get(page - 1));
				model.addAttribute(DISPLAY_PAGE, Utils.getPageToDisplay(pageList.size(), page));
				model.addAttribute(CURRENT_PAGE, page);
				model.addAttribute(FISRT_PAGE, 1);
				model.addAttribute(LAST_PAGE, pageList.size());
			}
		} else if (kind == 2) {
			List<String> tipSavedIds = user.getTipSavedIds();
			List<Tip> tips = tipService.searchByListId(Utils.toSqlInList(tipSavedIds));
			List<TipDTO> listDTO = TipDTO.toListDTO(tips);
			List<List<TipDTO>> pageList = TipDTO.toPageList(listDTO);
			if(pageList.size() != 0) {
				model.addAttribute(LIST_RECIPE, pageList.get(page - 1));
				model.addAttribute(DISPLAY_PAGE, Utils.getPageToDisplay(pageList.size(), page));
				model.addAttribute(CURRENT_PAGE, page);
				model.addAttribute(FISRT_PAGE, 1);
				model.addAttribute(LAST_PAGE, pageList.size());
			}
		}

		model.addAttribute(Constant.ATTRIBUTE_NAME.USER_PROFILE, userDTO);
		model.addAttribute(Constant.ATTRIBUTE_NAME.KIND_CATE, kind);
		return ResultView.USER.USER_DETAIL;
	}

	@RequestMapping( value = "/user/update", method = RequestMethod.POST)
	public String userUpdate( @RequestParam( value = "profileFile" , required = false) MultipartFile file,
			@ModelAttribute("user") User user,
			@RequestParam("userBirthday") String birthday,
			RedirectAttributes recirectAtt, HttpServletRequest request) {
		User updateUser = userService.getById(user.getId());
		Date dateOfBirth = DateFormator.parse_yyyy_MM_dd(birthday);
		if(file.getSize() != 0) {
			String filePath = Utils.uploadToStorage(file);
			updateUser.setProfileImage(filePath);
		}
		updateUser.setBirthday(dateOfBirth);
		updateUser.setPassword(user.getPassword());
		updateUser.setFullName(user.getFullName());
		updateUser.setEmail(user.getEmail());
		recirectAtt.addAttribute("id", user.getId());
		userService.update(updateUser);
		User sessionUser = userService.getById(user.getId());
		EntitySupport.transferToByteImage(sessionUser);
		Utils.setSession(request.getSession(),Constant.SESSION_NAME.USER_SESSION,sessionUser);
		return Utils.redirect("/user/profile");
	}
	
	@RequestMapping( value = "/user/getdata" ,method = RequestMethod.POST)
	@ResponseBody
	public UserProfileDTO getData(@RequestBody String data) {
		String id = data.replace("=", "");
		int userId = Integer.parseInt(id);
		User user = userService.getById(userId);
		return UserProfileDTO.toDTOForUpdate(user);
	}

}
