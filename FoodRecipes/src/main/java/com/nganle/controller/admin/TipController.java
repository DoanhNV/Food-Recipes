package com.nganle.controller.admin;

import static com.nganle.support.constant.Constant.ATTRIBUTE_NAME.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nganle.dto.BasicTipCate;
import com.nganle.dto.TipDTO;
import com.nganle.entity.Tip;
import com.nganle.entity.TipCategory;
import com.nganle.service.TipCateService;
import com.nganle.service.TipService;
import com.nganle.support.constant.Constant;
import com.nganle.support.constant.ResultView;
import com.nganle.support.util.Utils;

@Controller
@RequestMapping("/tip")
public class TipController {
	
	@Autowired
	private TipService tipService;
	
	@Autowired
	private TipCateService cateService;
	
	@RequestMapping("/create")
	public String create(ModelMap model) {
		List<TipCategory> cates = cateService.listAll();
		model.addAttribute(Constant.ATTRIBUTE_NAME.TIP_CATE, cates);
		return ResultView.TIP.CREATE;
	}
	
	@RequestMapping("/doCreate")
	public String doCreate(@ModelAttribute("tip") Tip tip,@RequestParam("cateids") List<String> cates,@RequestParam("profileImage") MultipartFile file, @RequestParam("editor1") String content) {
		String filePath = Constant.FILE_STORE + file.getOriginalFilename();
		File desFile = new File(filePath);
		try {
			if (file.getSize() != 0) {
				FileCopyUtils.copy(file.getBytes(), desFile);
			}
			if(file.getOriginalFilename() != null && !file.getOriginalFilename().isEmpty()) {
				tip.setFeatureImage(filePath);
			}
			tip.setContent(content);
			tip.setTipCateIds(cates);
			tipService.create(tip);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Utils.redirect("/tip/list");
	}
	
	@RequestMapping("/list")
	public String listAll(ModelMap model, @RequestParam(value = "page", defaultValue = "1") int page) {
		List<Tip> tips = tipService.listAll();
		List<TipDTO> listDTO = TipDTO.toListDTO(tips);
		List<List<TipDTO>> pageList = TipDTO.toPageList(listDTO);
		model.addAttribute(LIST_TIP, pageList.get(page - 1));
		model.addAttribute(DISPLAY_PAGE, Utils.getPageToDisplay(pageList.size(), page));
		model.addAttribute(CURRENT_PAGE, page);
		model.addAttribute(FISRT_PAGE, 1);
		model.addAttribute(LAST_PAGE, pageList.size());
		return ResultView.TIP.LIST_ALL;
	}
	
	@RequestMapping("/update")
	public String update(@RequestParam("id") int id,ModelMap model) {
		Tip tip = tipService.getById(id);
		List<TipCategory> cates = cateService.listAll();
		List<String> tipCateIds = tip.getTipCateIds();
		List<BasicTipCate> basicCate = new ArrayList<BasicTipCate>();
		for (TipCategory cate : cates) {
			BasicTipCate bCate = new BasicTipCate();
			bCate.setId(cate.getId());
			bCate.setTitle(cate.getCateName());
			for (String cateId : tipCateIds) {
				if(Integer.parseInt(cateId) == cate.getId()) {
					bCate.setChecked(Constant.HTML_ATTRIBUTE.CHECKED_VALUE);
					break;
				}
			}
			basicCate.add(bCate);
		}
		model.addAttribute(Constant.ATTRIBUTE_NAME.BASIC_CATE,basicCate);
		model.addAttribute(Constant.ATTRIBUTE_NAME.TIP,tip);
		return ResultView.TIP.UPDATE;
	}
	
	
	@RequestMapping("/doUpdate")
	public String doUpdate(@ModelAttribute("tip") Tip tip,@RequestParam("cateids") List<String> cates,@RequestParam("profileImage") MultipartFile file, @RequestParam("editor1") String content) {
		Tip updateTip = tipService.getById(tip.getId());
		String filePath = Constant.FILE_STORE + file.getOriginalFilename();
		File desFile = new File(filePath);
		try {
			if (file.getSize() != 0) {
				FileCopyUtils.copy(file.getBytes(), desFile);
			}
			if(file.getOriginalFilename() != null && !file.getOriginalFilename().isEmpty()) {
				updateTip.setFeatureImage(filePath);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		updateTip.setTitle(tip.getTitle());
		updateTip.setContent(content);
		updateTip.setTipCateIds(cates);
		tipService.update(updateTip);
		return Utils.redirect("/tip/list");
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam("id") int id) {
		tipService.delete(id);
		return Utils.redirect("/tip/list"); 
	}
	
	@RequestMapping("/change-status")
	public String changeStatus(@RequestParam("tip-data") String tipDatas,RedirectAttributes redirectAtt) {
		String[] data = tipDatas.split("-");
		Tip tip = tipService.getById(Integer.parseInt(data[0]));
		int status = tip.getStatus() == 1 ? 0 : 1;
		tip.setStatus(status);
		tipService.update(tip);
		redirectAtt.addFlashAttribute("page", data[1]);
		return Utils.redirect("/tip/list"); 
	}
}
