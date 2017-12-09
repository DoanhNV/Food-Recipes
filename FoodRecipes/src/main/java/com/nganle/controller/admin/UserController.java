package com.nganle.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nganle.dto.UserDTO;
import com.nganle.entity.User;
import com.nganle.service.UserService;
import com.nganle.support.constant.ResultView;
import com.nganle.support.util.Utils;

import static com.nganle.support.constant.Constant.ATTRIBUTE_NAME.*;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/list")
	public String getUsers(ModelMap model, @RequestParam(value = "page", defaultValue = "1") int page) {
		List<User> users = userService.listAll();
		List<UserDTO> listDTO = UserDTO.toListDTO(users);
		List<List<UserDTO>> pageList = UserDTO.pageListUser(listDTO);
		model.addAttribute(LIST_USER, pageList.get(page - 1));
		model.addAttribute(USER_PAGE, Utils.getPageToDisplay(pageList.size(), page));
		model.addAttribute(CURRENT_PAGE, page);
		model.addAttribute(FISRT_PAGE, 1);
		model.addAttribute(LAST_PAGE, pageList.size());
		return ResultView.ADMIN.LIST_USER;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(@RequestParam("userid") int userId) {
		userService.delete(userId);
		return "redirect:/user/list";
	}

	@RequestMapping(value = "/change-status", method = RequestMethod.POST)
	public String changeStatus(@RequestParam("userid") String userId,RedirectAttributes redirectAtt) {
		String[] data = userId.split("-");
		int status = 0;
		if (data[1].equals("deactive")) {
			status = 1;
		}
		userService.changeStatus(Integer.parseInt(data[0]), status);
		redirectAtt.addAttribute("page", Integer.parseInt(data[2]));
		return "redirect:/user/list";
	}
}
