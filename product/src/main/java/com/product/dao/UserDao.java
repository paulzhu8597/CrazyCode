package com.product.dao;

import com.product.entity.User;

public interface UserDao {
	public User querySingleUser(String userId,String userPassword);
}
