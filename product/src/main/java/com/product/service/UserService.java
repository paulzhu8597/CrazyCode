package com.product.service;

import java.util.List;
import java.util.Map;

import com.product.base.BaseMapper;
import com.product.entity.User;

/**
 * 验证用户登陆
 * 
 * @author product Email：1156721874@qq.com 
 * date：2015-7-17
 * @param User user
 * @return
 */
public interface UserService  {
	public User querySingleUser(String userId,String userPassword);

	public User isExist(String userName);

	public User countUser(User account);

	public List<User> queryNoMatch(Map<String, Object> map);
}
