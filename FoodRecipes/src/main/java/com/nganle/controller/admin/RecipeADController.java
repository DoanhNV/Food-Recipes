package com.nganle.controller.admin;

import static com.nganle.support.constant.Constant.ATTRIBUTE_NAME.*;
import static com.nganle.support.constant.Constant.SESSION_NAME.ADMIN_SESSION;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import com.nganle.support.validate.Validator;

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
	public String create(ModelMap model ,HttpServletRequest request) {
		if (!Validator.isExistSession(request.getSession(), ADMIN_SESSION)) {
			return Utils.redirect("/admin/login");
		}
		List<KindCateBasicDTO> listDTO = KindCateBasicDTO.toListDTO(kindService.listAll(), cateService.listAll());
		model.addAttribute(Constant.ATTRIBUTE_NAME.LIST_KIND_CATE, listDTO);
		List<Material> materials = materialService.listAll();
		List<MaterialDTO> lisMtDTO = MaterialDTO.toListDTO(materials);
		model.addAttribute(Constant.ATTRIBUTE_NAME.LIST_MATERIAL, lisMtDTO);
		model.addAttribute(Constant.ATTRIBUTE_NAME.RECIPE_HOUR, Utils.init(24, "giờ"));
		model.addAttribute(Constant.ATTRIBUTE_NAME.RECIPE_MINUTE,Utils.init(60, "phút"));
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
							@RequestParam("video") String videoUrl ,HttpServletRequest request){
		if (!Validator.isExistSession(request.getSession(), ADMIN_SESSION)) {
			return Utils.redirect("/admin/login");
		}
		Recipe recipe = new Recipe();
		List<String> filePaths = new ArrayList<String>();
		for (MultipartFile file : stepImgs) {
			filePaths.add(Utils.uploadToStorage(file));
		}
		String featurePath = Utils.uploadToStorage(featureFile);
		if (featurePath != null) {
			recipe.setFeatureImage(featurePath);
		}
		String estimateTime = String.valueOf(hour) +"@"+ String.valueOf(minute);
		String step = Step.toSQLArray(stepTexts, filePaths);
		recipe.setTitle(title);
		recipe.setContent(step);
		recipe.setCost(cost);
		recipe.setEstimateTime(estimateTime);
		recipe.setMaterialIds(materialIds);
		recipe.setRecipeCateIds(listKindCate);
		recipe.setVideoUrl(videoUrl);
		recipeService.create(recipe);
		cateService.increateNumberOfRecipe(Utils.toListCateId(listKindCate));
		return Utils.redirect("/admin_recipe/list");
	}
	
	
	@RequestMapping("/list")
	public String getUsers(ModelMap model, @RequestParam(value = "page", defaultValue = "1") int page,HttpServletRequest request) {
		if (!Validator.isExistSession(request.getSession(), ADMIN_SESSION)) {
			return Utils.redirect("/admin/login");
		}
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
	public String changeStatus(@RequestParam("recipe-data") String recipeData,RedirectAttributes redirectAttr,HttpServletRequest request ) {
		if (!Validator.isExistSession(request.getSession(), ADMIN_SESSION)) {
			return Utils.redirect("/admin/login");
		}
		String[] data = recipeData.split("-");
		String statusStr = data[1];
		int recipeId = Integer.parseInt(data[0]);
		int currentPage = Integer.parseInt(data[2]);
		int status = 0;
		if(statusStr.equals(Constant.STATUS.DEACTIVE)){
			status = 1;
		}
		recipeService.changeStatus(recipeId,status);
		redirectAttr.addAttribute("page", currentPage);
		return Utils.redirect("/admin_recipe/list");
	}
	
	@RequestMapping("/update")
	public String update(@RequestParam("id") int recipeId,ModelMap model,HttpServletRequest request) {
		if (!Validator.isExistSession(request.getSession(), ADMIN_SESSION)) {
			return Utils.redirect("/admin/login");
		}
		Recipe recipe = recipeService.getById(recipeId);
		recipe.setFeatureImage(Utils.convertToFileByte(recipe.getFeatureImage()));
		List<Step> listStep = Step.toListStep(recipe.getContent());
		List<String> recipeCateIds = recipe.getRecipeCateIds();
		List<Integer> materialIds = recipe.getMaterialIds();
		List<Material> materials = materialService.listAll();
		List<MaterialDTO> listCheckedDTO = MaterialDTO.toListCheckedDTO(materials, materialIds);
		List<KindCateBasicDTO> listDTO = KindCateBasicDTO.toListCheckedDTO(kindService.listAll(), cateService.listAll(),recipeCateIds);
		model.addAttribute(Constant.ATTRIBUTE_NAME.LIST_CHECKED_MATERIAL, listCheckedDTO);
		model.addAttribute(Constant.ATTRIBUTE_NAME.LIST_KIND_CATE, listDTO);
		model.addAttribute(Constant.ATTRIBUTE_NAME.LIST_STEP, listStep);
		model.addAttribute(Constant.ATTRIBUTE_NAME.RECIPE, recipe);
		model.addAttribute(Constant.ATTRIBUTE_NAME.COST, String.valueOf(recipe.getCost().longValue()));
		String[] time = recipe.getEstimateTime().split("@");
		model.addAttribute(Constant.ATTRIBUTE_NAME.RECIPE_HOUR, Utils.initTime(24, "giờ",Integer.parseInt(time[0])));
		model.addAttribute(Constant.ATTRIBUTE_NAME.RECIPE_MINUTE,Utils.initTime(60, "phút",Integer.parseInt(time[1])));
		
		return ResultView.ADMIN_RECIPE.UPDATE;
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam("id") int id ,HttpServletRequest request) {
		if (!Validator.isExistSession(request.getSession(), ADMIN_SESSION)) {
			return Utils.redirect("/admin/login");
		}
		recipeService.delete(id);
		return Utils.redirect("/admin_recipe/list");
	}
	
	
	@RequestMapping(value = "/doUpdate", method = RequestMethod.POST)
	public String doUpdate(@RequestParam("title") String title, @RequestParam("materialIds") List<Integer> materialIds,
							@RequestParam("stepImg") List<MultipartFile> stepImgs,
							@RequestParam("featureImage") MultipartFile featureFile,
							@RequestParam("hour") int hour, @RequestParam("minute") int minute,
							@RequestParam("cost") double cost ,
							@RequestParam("recipeCate") List<String> listKindCate,
							@RequestParam("stepText") List<String> stepTexts,
							@RequestParam("video") String videoUrl,
							@RequestParam("id") int id ,HttpServletRequest request){
		if (!Validator.isExistSession(request.getSession(), ADMIN_SESSION)) {
			return Utils.redirect("/admin/login");
		}
		Recipe recipe = recipeService.getById(id);
		List<Step> listStep = Step.toListStepV2(recipe.getContent());
		List<String> filePaths = Utils.uploadToStorageAndCheckUpdate(stepImgs,listStep);
		String featurePath = Utils.uploadToStorage(featureFile);
		if (!featurePath.equals("noFilePath")) {
			recipe.setFeatureImage(featurePath);
		}
		String estimateTime = String.valueOf(hour) +"@"+ String.valueOf(minute);
		String step = Step.toSQLArray(stepTexts, filePaths);
		recipe.setTitle(title);
		recipe.setContent(step);
		recipe.setCost(cost);
		recipe.setEstimateTime(estimateTime);
		recipe.setMaterialIds(materialIds);
		recipe.setRecipeCateIds(listKindCate);
		recipe.setVideoUrl(videoUrl);
		recipeService.update(recipe);
		cateService.increateNumberOfRecipe(Utils.toListCateId(listKindCate));
		return Utils.redirect("/admin_recipe/list");
	}
	
	@RequestMapping("/change-slide")
	public String changeSlide(@RequestParam("recipe-data") String recipeData,RedirectAttributes recirectAttr ,HttpServletRequest request) {
		if (!Validator.isExistSession(request.getSession(), ADMIN_SESSION)) {
			return Utils.redirect("/admin/login");
		}
		String[] data = recipeData.split("-");
		int recipeId = Integer.parseInt(data[0]);
		int slideValue = Integer.parseInt(data[1]);
		recipeService.changeSlide(recipeId, slideValue);
		recirectAttr.addFlashAttribute("page", Integer.parseInt(data[2]));
		return Utils.redirect("/admin_recipe/list");
	}
	

}
