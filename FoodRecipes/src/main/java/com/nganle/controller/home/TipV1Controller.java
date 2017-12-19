package com.nganle.controller.home;

import static com.nganle.support.constant.Constant.ATTRIBUTE_NAME.CURRENT_PAGE;
import static com.nganle.support.constant.Constant.ATTRIBUTE_NAME.DISPLAY_PAGE;
import static com.nganle.support.constant.Constant.ATTRIBUTE_NAME.FISRT_PAGE;
import static com.nganle.support.constant.Constant.ATTRIBUTE_NAME.LAST_PAGE;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nganle.dto.TipForHomeDTO;
import com.nganle.entity.Tip;
import com.nganle.entity.TipCategory;
import com.nganle.service.TipCateService;
import com.nganle.service.TipService;
import com.nganle.support.constant.Constant;
import com.nganle.support.constant.ResultView;
import com.nganle.support.util.Utils;

@RequestMapping("/tipv1")
@Controller
public class TipV1Controller {

	@Autowired
	private TipCateService cateService;
	@Autowired
	private TipService tipService;

	@RequestMapping("/view")
	public String view(@RequestParam(value = "cate", required = false, defaultValue = "-1") int cateId,
			@RequestParam(value = "page", required = false, defaultValue = "1") int page, ModelMap model) {
		List<TipCategory> cates = cateService.listAll();
		model.addAttribute(Constant.ATTRIBUTE_NAME.LIST_TIP_CATE, cates);
		List<List<TipForHomeDTO>> pageList = new ArrayList<List<TipForHomeDTO>>();
		List<Tip> tips = new ArrayList<Tip>();
		if (cateId == -1) {
			tips = tipService.listAll();
		} else {
			tips = tipService.searchByCateId(cateId);
		}
		List<TipForHomeDTO> listDTO = TipForHomeDTO.toListDTO(tips);
		pageList = TipForHomeDTO.toPageList(listDTO);
		if (pageList.size() != 0) {
			model.addAttribute(Constant.ATTRIBUTE_NAME.LIST_TIP, pageList.get(page - 1));
			model.addAttribute(DISPLAY_PAGE, Utils.getPageToDisplay(pageList.size(), page));
			model.addAttribute(CURRENT_PAGE, page);
			model.addAttribute(FISRT_PAGE, 1);
			model.addAttribute(LAST_PAGE, pageList.size());
		}
		return ResultView.TIP.TIP_VIEW;
	}
	
	@RequestMapping("/detail")
	public String viewDetail(@RequestParam("id") int id,ModelMap model) {
		Tip tip = tipService.getById(id);
		List<Tip> suggestList = tipService.getSuggest(id, 5);
		tipService.increateView(id);
		model.addAttribute(Constant.ATTRIBUTE_NAME.TIP, TipForHomeDTO.toListDTODetail(tip));
		model.addAttribute(Constant.ATTRIBUTE_NAME.TIP_SUGGEST, TipForHomeDTO.toListDTO(suggestList));
		return ResultView.TIP.TIP_DETAIL;
	}
}
