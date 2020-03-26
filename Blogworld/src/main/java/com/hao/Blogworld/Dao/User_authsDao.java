package com.hao.Blogworld.Dao;

import com.hao.Blogworld.Entity.User;
import com.hao.Blogworld.Entity.User_auths;

public interface User_authsDao {
    int add(User_auths u);
    int update(User_auths u);
    User_auths queryUserByU_id(Long u_id);
}
