package com.phz.web;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.phz.entity.User;
import com.phz.service.UserService;

@Controller
public class UserServlet {
	@Autowired
	private UserService userService;

	@RequestMapping("/init.do")
	public String init() {
		return "login";
	}

	@RequestMapping("/login.do")
	public String login(String username, String pwd, HttpSession session, Model model) {
		User user = userService.queryUser(username, pwd);
		if (user == null) {
			model.addAttribute("message", "用户名或密码不对");
			return "login";
		}
		session.setAttribute("user", user);
		return "main";
	}

	@RequestMapping("/init2.do")
	public String init2() {
		return "regist";
	}

	@RequestMapping("registResult.do")
	public String regist(String username, String pwd, String age, String sex) {
		User user=new User();
		user.setUserName(username);
		user.setUserPwd(pwd);
		user.setUserAge(age);
		user.setUserSex(sex);
		userService.addUser(user);
		System.out.println(sex);
		return "login";
	}
	
	@ResponseBody
	@RequestMapping("/checkName.do")
	public String checkName(String name,HttpServletResponse resp) {
		resp.setCharacterEncoding("UTF-8");
		User user = userService.checkName(name);
		String message = "该用户名可用";
		if (user != null) {
			message = "该用户名不可用";
		}
		return message;
	}
}
