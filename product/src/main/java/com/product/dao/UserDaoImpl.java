package com.product.dao;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Component;

import com.product.entity.User;

@Component
public class UserDaoImpl implements UserDao {

	 @Resource
	 private SqlSessionTemplate sqlSessionTemplate;
	public User querySingleUser(String userId,String userPassword) {
		Map param = new HashMap(8);
		param.put("userId", userId);
		param.put("userPassword", userPassword);
		return sqlSessionTemplate.selectOne("com.product.mapper.UserMapper.querySingleUser", param);
	}
	public SqlSessionTemplate getSqlSessionTemplate() {
		return sqlSessionTemplate;
	}
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

}
