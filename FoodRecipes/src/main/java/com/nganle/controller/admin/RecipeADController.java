package com.nganle.controller.admin;

import static com.nganle.support.constant.Constant.ATTRIBUTE_NAME.*;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nganle.dto.KindCateBasicDTO;
import com.nganle.dto.MaterialDTO;
import com.nganle.dto.RecipeDTO;
import com.nganle.dto.TimeRecipe;
import com.nganle.entity.Material;
import com.nganle.entity.Recipe;
import com.nganle.entity.Step;
import com.nganle.service.KindOfCateService;
import com.nganle.service.MaterialService;
import com.nganle.service.RecipeCategoryService;
import com.nganle.service.RecipeService;
import com.nganle.support.constant.Constant;
import com.nganle.support.constant.ResultView;
import com.nganle.support.util.Utils;

@Controller
@RequestMapping("/admin_recipe")
public class RecipeADController {

	@Autowired
	private KindOfCateService kindService;
	@Autowired
	private RecipeCategoryService cateService;
	@Autowired
	private MaterialService materialService;
	@Autowired
	private RecipeService recipeService;

	@RequestMapping("/create")
	public String create(ModelMap model) {
		List<KindCateBasicDTO> listDTO = KindCateBasicDTO.toListDTO(kindService.listAll(), cateService.listAll());
		model.addAttribute(Constant.ATTRIBUTE_NAME.LIST_KIND_CATE, listDTO);
		List<Material> materials = materialService.listAll();
		List<MaterialDTO> lisMtDTO = MaterialDTO.toListDTO(materials);
		model.addAttribute(Constant.ATTRIBUTE_NAME.LIST_MATERIAL, lisMtDTO);
		List<TimeRecipe> hours = Utils.init(24, "giá»�");
		List<TimeRecipe> minutes = Utils.init(60, "phÃºt");
		model.addAttribute(Constant.ATTRIBUTE_NAME.RECIPE_HOUR, hours);
		model.addAttribute(Constant.ATTRIBUTE_NAME.RECIPE_MINUTE,minutes);
		return ResultView.ADMIN_RECIPE.CREATE;
	}

	@RequestMapping(value = "/doCreate", method = RequestMethod.POST)
	public String doCreate(@RequestParam("title") String title, @RequestParam("materialIds") List<Integer> materialIds,
							@RequestParam("stepImg") List<MultipartFile> stepImgs,
							@RequestParam("featureImage") MultipartFile featureFile,
							@RequestParam("hour") int hour, @RequestParam("minute") int minute,
							@RequestParam("cost") double cost ,
							@RequestParam("recipeCate") List<String> listKindCate,
							@RequestParam("stepText") List<String> stepTexts,
							@RequestParam("video") String videoUrl){
		Recipe recipe = new Recipe();
		List<String> filePaths = new ArrayList<String>();
		for (MultipartFile file : stepImgs) {
			filePaths.add(Utils.uploadToStorage(file));
		}
		String featurePath = Utils.uploadToStorage(featureFile);
		if (featurePath != null) {
			recipe.setFeatureImage(featurePath);
		}
		String estimateTime = String.valueOf(hour) +"||"+ String.valueOf(minute);
		String step = Step.toSQLArray(stepTexts, filePaths);
		recipe.setTitle(title);
		recipe.setContent(step);
		recipe.setCost(cost);
		recipe.setEstimateTime(estimateTime);
		recipe.setMaterialIds(materialIds);
		recipe.setRecipeCateIds(listKindCate);
		recipe.setVideoUrl(videoUrl);
		recipeService.create(recipe);
		return Utils.redirect("/admin_recipe/list");
	}
	
	
	@RequestMapping("/list")
	public String getUsers(ModelMap model, @RequestParam(value = "page", defaultValue = "1") int page) {
		List<Recipe> recipes = recipeService.listAll();
		List<RecipeDTO> listDTDO = RecipeDTO.toListDTDO(recipes);
		List<List<RecipeDTO>> pageList = RecipeDTO.toPageList(listDTDO);
		model.addAttribute(LIST_RECIPE, pageList.get(page - 1));
		model.addAttribute(DISPLAY_PAGE, Utils.getPageToDisplay(pageList.size(), page));
		model.addAttribute(CURRENT_PAGE, page);
		model.addAttribute(FISRT_PAGE, 1);
		model.addAttribute(LAST_PAGE, pageList.size());
		return ResultView.ADMIN_RECIPE.LIST_ALL;
	}
	
	@RequestMapping("/change-status")
	public String changeStatus(@RequestParam("recipe-data") String recipeData,RedirectAttributes redirectAttr ) {
		String[] data = recipeData.split("-");
		String statusStr = data[1];
		int recipeId = Integer.parseInt(data[0]);
		int currentPage = Integer.parseInt(data[2]);
		int status = 0;
		if(statusStr.equals(Constant.STATUS.ACTIVE)){
			status = 1;
		}
		recipeService.changeStatus(recipeId,status);
		redirectAttr.addAttribute("page", currentPage);
		return Utils.redirect("/admin_recipe/list");
	}
	
	@RequestMapping("/update")
	public String update(@RequestParam("id") int recipeId,ModelMap model) {
		Recipe recipe = recipeService.getById(recipeId);
		List<Step> listStep = Step.toListStep(recipe.getContent());
		List<String> recipeCateIds = recipe.getRecipeCateIds();
		List<KindCateBasicDTO> listDTO = KindCateBasicDTO.toListCheckedDTO(kindService.listAll(), cateService.listAll(),recipeCateIds);
		model.addAttribute(Constant.ATTRIBUTE_NAME.LIST_KIND_CATE, listDTO);
		model.addAttribute(Constant.ATTRIBUTE_NAME.LIST_STEP, listStep);
		return ResultView.ADMIN_RECIPE.UPDATE;
	}

}
