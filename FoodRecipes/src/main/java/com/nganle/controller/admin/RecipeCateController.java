package com.nganle.controller.admin;

import static com.nganle.support.constant.Constant.ATTRIBUTE_NAME.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nganle.dto.KindOfCateDTO;
import com.nganle.dto.RecipeCateDTO;
import com.nganle.entity.KindOfCate;
import com.nganle.entity.RecipeCategory;
import com.nganle.service.KindOfCateService;
import com.nganle.service.RecipeCategoryService;
import com.nganle.support.constant.Constant;
import com.nganle.support.constant.ResultView;
import com.nganle.support.util.Utils;

@Controller
@RequestMapping("/recipecate")
public class RecipeCateController {

	@Autowired
	private RecipeCategoryService cateService;

	@Autowired
	private KindOfCateService kindService;

	@RequestMapping("/create")
	public String create(ModelMap model) {
		List<KindOfCate> kinds = kindService.listAll();
		List<KindOfCateDTO> listDTO = KindOfCateDTO.toListDTO(kinds);
		model.addAttribute(Constant.ATTRIBUTE_NAME.LIST_KIND, listDTO);
		return ResultView.RECIPE_CATE.CREATE;
	}

	@RequestMapping(value = "/doCreate", method = RequestMethod.POST)
	public String doCreate(@ModelAttribute("recipecate") RecipeCategory cate) {
		cateService.create(cate);
		return Utils.redirect("/recipecate/list");
	}

	@RequestMapping(value = "/list")
	public String listAll(ModelMap model, @RequestParam(value = "page", defaultValue = "1") int page) {
		List<RecipeCategory> cates = cateService.listAll();
		List<RecipeCateDTO> listDTO = RecipeCateDTO.toListDTO(cates);
		List<List<RecipeCateDTO>> pageList = RecipeCateDTO.toPageList(listDTO);
		model.addAttribute(LIST_RECIPE_CATE, pageList.get(page - 1));
		model.addAttribute(DISPLAY_PAGE, Utils.getPageToDisplay(pageList.size(), page));
		model.addAttribute(CURRENT_PAGE, page);
		model.addAttribute(FISRT_PAGE, 1);
		model.addAttribute(LAST_PAGE, pageList.size());
		return ResultView.RECIPE_CATE.LIST_ALL;
	}

	@RequestMapping("/update")
	public String update(@RequestParam("recipecate-data") String cateData, ModelMap model) {
		String[] data = cateData.split("-");
		RecipeCategory cate = cateService.getById(Integer.parseInt(data[0]));
		List<KindOfCate> kinds = kindService.listAll();
		List<KindOfCateDTO> listDTO = KindOfCateDTO.toListDTO(kinds);
		model.addAttribute(LIST_KIND, listDTO);
		model.addAttribute(RECIPE_CATE, cate);
		return ResultView.RECIPE_CATE.UPDATE;
	}

	@RequestMapping("/doUpdate")
	public String doUpdate(@ModelAttribute("recipecate") RecipeCategory cate) {
		RecipeCategory updateCate = cateService.getById(cate.getId());
		updateCate.setCateTitle(cate.getCateTitle());
		updateCate.setKindId(cate.getKindId());
		cateService.update(updateCate);
		return Utils.redirect("/recipecate/list");
	}
	
	@RequestMapping("/delete")
	public String delete(@ModelAttribute("id") int id) {
		cateService.delete(id);
		return Utils.redirect("/recipecate/list");
	}
	
	@RequestMapping("/change-status")
	public String changeStatus(@RequestParam("recipecate-data") String cateData,RedirectAttributes redirectAtt) {
		String[] data = cateData.split("-");
		RecipeCategory cate = cateService.getById(Integer.parseInt(data[0]));
		int status = data[1].equals(Constant.STATUS.ACTIVE) ? 0 : 1;
		cate.setStatus(status);
		cateService.update(cate);
		redirectAtt.addAttribute("page", Integer.parseInt(data[2]));
		return Utils.redirect("/recipecate/list");
	}


}
