package com.product.mapper;

import com.product.base.BaseMapper;
import com.product.entity.User;


public interface UserMapper extends BaseMapper {

	User querySingleUser(User user);

}
