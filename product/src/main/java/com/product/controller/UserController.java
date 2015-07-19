package com.product.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.product.entity.ResFormMap;
import com.product.entity.User;
import com.product.mapper.ResourcesMapper;
import com.product.mapper.UserMapper;
import com.product.util.Common;
import com.product.util.TreeObject;
import com.product.util.TreeUtil;

@Controller
@RequestMapping("/")
public class UserController {
	
@Resource
private UserMapper usermapper;

@Resource
private ResourcesMapper resourcesMapper;


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
		return "redirect:/index.do";
	}
	return "/login";
}

/**
 * @return
 * @throws Exception
 */
@RequestMapping("index")
public String index(Model model) throws Exception {
	List<ResFormMap> mps = resourcesMapper.findByWhere(new ResFormMap());
	List<TreeObject> list = new ArrayList<TreeObject>();
	for (ResFormMap map : mps) {
		TreeObject ts = new TreeObject();
		Common.flushObject(ts, map);
		list.add(ts);
	}
	TreeUtil treeUtil = new TreeUtil();
	List<TreeObject> ns = treeUtil.getChildTreeObjects(list, 0);
	model.addAttribute("list", ns);
	return "/index";
}



public ResourcesMapper getResourcesMapper() {
	return resourcesMapper;
}

public void setResourcesMapper(ResourcesMapper resourcesMapper) {
	this.resourcesMapper = resourcesMapper;
}

public UserMapper getUsermapper() {
	return usermapper;
}


public void setUsermapper(UserMapper usermapper) {
	this.usermapper = usermapper;
}

}
