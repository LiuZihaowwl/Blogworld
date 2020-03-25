package com.hao.Blogworld.Service;

import com.hao.Blogworld.Entity.User;

public interface Userservice {
    int add(User user);
    int update(User user);
    User queryUserByPhone(String phone);
}
