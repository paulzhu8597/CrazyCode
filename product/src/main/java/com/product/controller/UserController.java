package com.product.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.product.util.Common;
import com.product.service.UserService;

@Controller
@RequestMapping("/product")
public class UserController {
@Resource
private UserService userservice;

@RequestMapping(value = "/login.do", method = RequestMethod.GET, produces = "text/html; charset=utf-8")
public String login(HttpServletRequest request) {
	request.removeAttribute("error");
	return "/login";
}

@RequestMapping(value = "/login.do", method = RequestMethod.POST, produces = "text/html; charset=utf-8")
public String querySingleUser(Model model,String userId,String userPassword)
{
    System.out.println("UserController.querySingleUser()");
	if (Common.isEmpty(userId) || Common.isEmpty(userPassword)) {
		model.addAttribute("error", "用户名或密码不能为空！");
		return "/login";
	}
	if(Common.isNotEmpty(userservice.querySingleUser(userId,userPassword)))
	{
		return "redirect:index.jsp";
	}
	return "/login";
}

public UserService getUserservice() {
	return userservice;
}

public void setUserservice(UserService userservice) {
	this.userservice = userservice;
}

}
