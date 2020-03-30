package com.hao.Blogworld.Dao.master;

import com.hao.Blogworld.Entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface UserDao {
    int add(@Param("user") User user);
    int update(User user);
    User queryUserByPhone(@Param("phone") String phone);
    User queryUserById(Long id);
}
