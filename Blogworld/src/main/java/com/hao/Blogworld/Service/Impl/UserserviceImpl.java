package com.hao.Blogworld.Service.Impl;

import com.hao.Blogworld.Dao.UserDao;
import com.hao.Blogworld.Entity.User;
import com.hao.Blogworld.Service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserserviceImpl implements Userservice{
    @Autowired
    private UserDao userDao;
    public int add(User user){
       return userDao.add(user);
    }
    public int update(User user){
        return userDao.update(user);
    }
    public User queryUserByPhone(String phone){
        return userDao.queryUserByPhone(phone);
    }
    public User queryUserById(Long id){return userDao.queryUserById(id);}
}
