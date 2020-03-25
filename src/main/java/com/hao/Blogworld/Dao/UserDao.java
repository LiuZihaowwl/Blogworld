package com.hao.Blogworld.Dao;

import com.hao.Blogworld.Entity.User;

public interface UserDao {
    int add(User user);
    int update(User user);
    User queryUserByPhone(String phone);
}
