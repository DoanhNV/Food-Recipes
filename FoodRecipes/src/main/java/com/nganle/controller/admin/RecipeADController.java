package com.nganle.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.nganle.dto.KindCateBasicDTO;
import com.nganle.dto.MaterialDTO;
import com.nganle.entity.Material;
import com.nganle.entity.Recipe;
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
		return ResultView.ADMIN_RECIPE.CREATE;
	}

	@RequestMapping(value = "/doCreate" ,method = RequestMethod.POST)
	public String doCreate(@ModelAttribute("recipe") Recipe recipe, @RequestParam("recipeCate") List<Integer> cateIds,
			@RequestParam("recipeFiles") List<MultipartFile> files,
			@RequestParam( value = "testField") int testValue) {
		for (MultipartFile file : files) {
			file.getOriginalFilename();
		}
		return Utils.redirect("");
	}
}
