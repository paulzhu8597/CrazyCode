package com.product.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.product.entity.User;
import com.product.mapper.UserMapper;
import com.product.util.Common;

@Controller
@RequestMapping("/")
public class UserController {
	static
	{
		System.out.println("UserController static area inint....");
	}
	public UserController()
	{
		System.out.println("UserController.UserController()");
	}
@Resource
private UserMapper usermapper;



@RequestMapping("login")
public String querySingleUser(Model model,@RequestParam(value="userId",required=false) String userId,@RequestParam(value="userPassword",required=false) String userPassword)
{
    System.out.println("UserController.querySingleUser()");
	if (Common.isEmpty(userId) || Common.isEmpty(userPassword)) {
		model.addAttribute("error", "用户名或密码不能为空！");
		return "/login";
	}
	User  user = new User();
	user.setUserId(userId);
	user.setUserPassword(userPassword);
	if(Common.isNotEmpty(usermapper.querySingleUser(user)))
	{
		return "redirect:index.jsp";
	}
	return "/login";
}



public UserMapper getUsermapper() {
	return usermapper;
}



public void setUsermapper(UserMapper usermapper) {
	this.usermapper = usermapper;
}


}
