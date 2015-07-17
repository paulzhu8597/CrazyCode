package com.product.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.product.dao.UserDao;
import com.product.entity.User;

@Component
public class UserserviceImpl implements UserService {

	@Resource
	private UserDao userdao;
	public User querySingleUser(String userId,String userPassword) {
		// TODO Auto-generated method stub
		return userdao.querySingleUser(userId, userPassword);
	}

	public User isExist(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	public User countUser(User account) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<User> queryNoMatch(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	public UserDao getUserdao() {
		return userdao;
	}

	public void setUserdao(UserDao userdao) {
		this.userdao = userdao;
	}
	
}
