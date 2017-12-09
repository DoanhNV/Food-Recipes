package com.nganle.controller.admin;

import static com.nganle.support.constant.Constant.ATTRIBUTE_NAME.CURRENT_PAGE;
import static com.nganle.support.constant.Constant.ATTRIBUTE_NAME.FISRT_PAGE;
import static com.nganle.support.constant.Constant.ATTRIBUTE_NAME.LAST_PAGE;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nganle.dto.MaterialDTO;
import com.nganle.entity.Material;
import com.nganle.entity.User;
import com.nganle.service.MaterialService;
import com.nganle.support.constant.Constant;
import com.nganle.support.constant.ResultView;
import com.nganle.support.util.Utils;
import static com.nganle.support.constant.Constant.ATTRIBUTE_NAME.*;

@Controller
@RequestMapping("/material")
public class MaterialController {

	@Autowired
	private MaterialService materialService;

	@RequestMapping(value = "/doCreate", method = RequestMethod.POST)
	public String doCreate(@ModelAttribute("material") Material material,
			@RequestParam("materialfile") MultipartFile file, HttpServletRequest request) {
		String filePath = Constant.FILE_STORE + file.getOriginalFilename();
		File desFile = new File(filePath);
		try {
			if (file.getSize() != 0) {
				FileCopyUtils.copy(file.getBytes(), desFile);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute(Constant.SESSION_NAME.ADMIN_SESSION);
		if(user != null) {
			material.setCreaterId(user.getId());
		}
		material.setFeatureImage(filePath);
		material.setCreateTime(new Date());
		materialService.create(material);
		return Utils.redirect("/material/list");
	}

	@RequestMapping("/create")
	public String create() {
		return ResultView.MATERIAL.CREATE;
	}

	@RequestMapping("/list")
	public String listAll(ModelMap model, @RequestParam(value = "page", defaultValue = "1") int page) {
		List<Material> materials = materialService.listAll();
		List<MaterialDTO> listDTO = MaterialDTO.toListDTO(materials);
		List<List<MaterialDTO>> pageList = MaterialDTO.toPageList(listDTO);
		model.addAttribute(LIST_MATERIAL, pageList.get(page - 1));
		model.addAttribute(DISPLAY_PAGE, Utils.getPageToDisplay(pageList.size(), page));
		model.addAttribute(CURRENT_PAGE, page);
		model.addAttribute(FISRT_PAGE, 1);
		model.addAttribute(LAST_PAGE, pageList.size());
		return ResultView.MATERIAL.LIST_ALL;
	}

	@RequestMapping("/update")
	public String update(@RequestParam("materialid") int id, ModelMap model) {
		Material material = materialService.getById(id);
		model.addAttribute(Constant.ATTRIBUTE_NAME.MATERIAL, material);
		return ResultView.MATERIAL.UPDATE;
	}

	@RequestMapping(value = "/doUpdate", method = RequestMethod.POST)
	public String doUpdate(@ModelAttribute("material") Material material, @RequestParam("materialfile") MultipartFile file, HttpServletRequest request) {
		String filePath = Constant.FILE_STORE + file.getOriginalFilename();
		File desFile = new File(filePath);
		try {
			if (file.getSize() != 0) {
				FileCopyUtils.copy(file.getBytes(), desFile);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(file.getOriginalFilename() != null && !file.getOriginalFilename().isEmpty()) {
			material.setFeatureImage(filePath);
		}
		material.setCreateTime(new Date());
		materialService.update(material);
		return Utils.redirect("/material/list");
	}
	
	@RequestMapping(value = "/change-status")
	public String changeStatus(@RequestParam("material-data") String userId,RedirectAttributes redirectAtt) {
		String[] data = userId.split("-");
		int status = 0;
		if (data[1].equals("deactive")) {
			status = 1;
		}
		Material material = materialService.getById(Integer.parseInt(data[0]));
		material.setStatus(status);
		materialService.update(material);
		redirectAtt.addAttribute("page", Integer.parseInt(data[2]));
		return Utils.redirect("/material/list");
	}
	
	@RequestMapping(value = "/delete")
	public String delete(@RequestParam("material-data") int id,RedirectAttributes redirectAtt) {
		materialService.deleteById(id);
		return Utils.redirect("/material/list");
	}



}
