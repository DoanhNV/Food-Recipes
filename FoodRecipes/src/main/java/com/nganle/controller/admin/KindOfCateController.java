package com.nganle.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nganle.dto.KindOfCateDTO;
import com.nganle.entity.KindOfCate;
import com.nganle.service.KindOfCateService;
import com.nganle.support.constant.Constant;
import com.nganle.support.constant.ResultView;
import com.nganle.support.util.Utils;

@Controller
@RequestMapping("/kind")
public class KindOfCateController {

	@Autowired
	private KindOfCateService kindService;

	@RequestMapping("/create")
	public String create() {
		return ResultView.KINDOFCATE.CREATE;
	}

	@RequestMapping(value = "/doCreate",produces = "text/plain;charset=UTF-8")
	public String doCreate(@RequestParam("kindTitle") String kindTitle) {
		KindOfCate kind = new KindOfCate(kindTitle);
		kindService.create(kind);
		return Utils.redirect("/kind/list");
	}

	@RequestMapping("/list")
	public String doCreate(ModelMap model) {
		List<KindOfCate> kinds = kindService.listAll();
		List<KindOfCateDTO> listDTO = KindOfCateDTO.toListDTO(kinds);
		model.addAttribute(Constant.ATTRIBUTE_NAME.LIST_KIND, listDTO);
		return ResultView.KINDOFCATE.LIST_ALL;
	}
	
	@RequestMapping("/update")
	public String update (@RequestParam("kindid") int id,ModelMap model) {
		KindOfCate kind = kindService.findById(id);
		model.addAttribute(Constant.ATTRIBUTE_NAME.KIND, kind);
		return ResultView.KINDOFCATE.UPDATE;
	}
	
	@RequestMapping("/doUpdate")
	public String doUpdate(@ModelAttribute("kind") KindOfCate kind) {
		KindOfCate updateKind = kindService.findById(kind.getId());
		if(updateKind != null) {
			updateKind.setKindTitle(kind.getKindTitle());
		}
		kindService.update(updateKind);
		return Utils.redirect("/kind/list");
	}
	
	@RequestMapping("/change-status")
	public String changeStatus(@ModelAttribute("kind-data") String kindData) {
		String[] data = kindData.split("-");
		KindOfCate updateKind = kindService.findById(Integer.parseInt(data[0]));
		if(updateKind != null) {
			int status = data[1].equals(Constant.STATUS.ACTIVE) ? 0 : 1;
			updateKind.setStatus(status);
		}
		kindService.update(updateKind);
		return Utils.redirect("/kind/list");
	}
}
