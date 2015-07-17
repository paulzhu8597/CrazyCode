package com.product.entity;
/*
 * 登陆用户
 */
public class User {
//登陆账户
private String userId="";
private String userName="";
//登陆密码
private String userPassword="";

public String getUserPassword() {
	return userPassword;
}
public void setUserPassword(String userPassword) {
	this.userPassword = userPassword;
}
public String getUserId() {
	return userId;
}
public void setUserId(String userId) {
	this.userId = userId;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
@Override
public String toString() {
	return "User [userId=" + userId + ", userName=" + userName
			+ ", userPassword=" + userPassword + "]";
}

}
