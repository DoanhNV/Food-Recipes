package com.nganle.controller.admin;

import static com.nganle.support.constant.Constant.ATTRIBUTE_NAME.*;
import static com.nganle.support.constant.Constant.SESSION_NAME.ADMIN_SESSION;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nganle.dto.TipCateDTO;
import com.nganle.entity.TipCategory;
import com.nganle.service.TipCateService;
import com.nganle.support.constant.Constant;
import com.nganle.support.constant.ResultView;
import com.nganle.support.util.Utils;
import com.nganle.support.validate.Validator;

@Controller
@RequestMapping("/tipcate")
public class TipCateController {

	@Autowired
	private TipCateService cateService;

	@RequestMapping("/create")
	public String create(HttpServletRequest request) {
		if (!Validator.isExistSession(request.getSession(), ADMIN_SESSION)) {
			return Utils.redirect("/admin/login");
		}
		return ResultView.TIP_CATE.CREATE;
	}

	@RequestMapping(value = "/doCreate", method = RequestMethod.POST)
	public String doCreate(@ModelAttribute("tipcate") TipCategory cate ,HttpServletRequest request) {
		if (!Validator.isExistSession(request.getSession(), ADMIN_SESSION)) {
			return Utils.redirect("/admin/login");
		}
		cateService.create(cate);
		return Utils.redirect("/tipcate/list");
	}

	@RequestMapping(value = "/list")
	public String listAll(ModelMap model, @RequestParam(value = "page", defaultValue = "1") int page ,HttpServletRequest request) {
		if (!Validator.isExistSession(request.getSession(), ADMIN_SESSION)) {
			return Utils.redirect("/admin/login");
		}
		List<TipCategory> cates = cateService.listAll();
		List<TipCateDTO> listDTO = TipCateDTO.toListDTO(cates);
		List<List<TipCateDTO>> pageList = TipCateDTO.toPageList(listDTO);
		model.addAttribute(LIST_TIP_CATE, pageList.get(page - 1));
		model.addAttribute(DISPLAY_PAGE, Utils.getPageToDisplay(pageList.size(), page));
		model.addAttribute(CURRENT_PAGE, page);
		model.addAttribute(FISRT_PAGE, 1);
		model.addAttribute(LAST_PAGE, pageList.size());
		return ResultView.TIP_CATE.LIST_ALL;
	}
	
	@RequestMapping("/update")
	public String update(@RequestParam("id") int id,ModelMap model ,HttpServletRequest request) {
		if (!Validator.isExistSession(request.getSession(), ADMIN_SESSION)) {
			return Utils.redirect("/admin/login");
		}
		TipCategory cate = cateService.getById(id);
		model.addAttribute(TIP_CATE, cate);
		return ResultView.TIP_CATE.UPDATE;
	}
	
	@RequestMapping("/doUpdate")
	public String doUpdate(@ModelAttribute("tipcate") TipCategory cate ,HttpServletRequest request) {
		if (!Validator.isExistSession(request.getSession(), ADMIN_SESSION)) {
			return Utils.redirect("/admin/login");
		}
		TipCategory upcateCate = cateService.getById(cate.getId());
		if(upcateCate != null) {
			upcateCate.setCateName(cate.getCateName());
		}
		cateService.update(upcateCate);
		return Utils.redirect("/tipcate/list");
	}
	
	@RequestMapping("/change-status")
	public String doUpdate(@RequestParam("tip-data") String tipData,RedirectAttributes redirectAtt ,HttpServletRequest request) {
		if (!Validator.isExistSession(request.getSession(), ADMIN_SESSION)) {
			return Utils.redirect("/admin/login");
		}
		String[] data = tipData.split("-");
		TipCategory upcateCate = cateService.getById(Integer.parseInt(data[0]));
		int status = data[1].equals(Constant.STATUS.ACTIVE) ? 0 : 1;
		upcateCate.setStatus(status);
		cateService.update(upcateCate);
		redirectAtt.addAttribute("page", Integer.parseInt(data[2]));
		return Utils.redirect("/tipcate/list");
	}
	

	@RequestMapping("/delete")
	public String update(@RequestParam("id") int id ,HttpServletRequest request) {
		if (!Validator.isExistSession(request.getSession(), ADMIN_SESSION)) {
			return Utils.redirect("/admin/login");
		}
		cateService.delete(id);
		return Utils.redirect("/tipcate/list");
	}

}
