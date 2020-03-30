package com.hao.Blogworld.Service.Impl;

import com.hao.Blogworld.Dao.master.UserDao;
import com.hao.Blogworld.Entity.User;
import com.hao.Blogworld.Service.Userservice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class UserserviceImpl implements Userservice{
    private static final Logger LOGGER = LoggerFactory.getLogger(UserserviceImpl.class);
    @Autowired
    private UserDao userDao;
    @Autowired
    private RedisTemplate redisTemplate;
    public int add(User user){
       return userDao.add(user);
    }
    public int update(User user){
        return userDao.update(user);
    }
    public User queryUserByPhone(String phone){
        // 开启事务支持，在同一个 Connection 中执行命令
        redisTemplate.setEnableTransactionSupport(true);
        String key = "user_"+phone;
        ValueOperations<String, User> operations = redisTemplate.opsForValue();
        // 缓存存在
        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
            User user = operations.get(key);

            LOGGER.info("UserServiceImpl.queryUserByPhone() : 从缓存中获取了用户 >> " + user.toString());
            return user;
        }


        User user = userDao.queryUserByPhone(phone);

        // 插入缓存
        operations.set(key, user, 10, TimeUnit.SECONDS);
        LOGGER.info("UserServiceImpl.queryUserByPhone() : 用户插入缓存 >> " + user.toString());

        return user;
    }
    public User queryUserById(Long id){return userDao.queryUserById(id);}
}
