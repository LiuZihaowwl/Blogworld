package com.hao.Blogworld.Service.Impl;

import com.hao.Blogworld.Dao.master.User_authsDao;
import com.hao.Blogworld.Entity.User_auths;
import com.hao.Blogworld.Service.User_authsservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class User_authsserviceImpl implements User_authsservice {
    @Autowired
    User_authsDao user_authsDao;
    public int add(User_auths u){
        return user_authsDao.add(u);
    }
    public int update(User_auths u){
        return user_authsDao.update(u);
    }
    public User_auths queryUserByU_id(Long u_id){
        return user_authsDao.queryUserByU_id(u_id);
    }

}
