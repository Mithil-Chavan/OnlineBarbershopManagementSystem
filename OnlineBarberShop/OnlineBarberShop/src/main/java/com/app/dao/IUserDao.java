package com.app.dao;

import com.app.pojos.Users;


public interface IUserDao {
Users  auntheticateUser(String email, String pwd);
String registerUser(Users user);
}
