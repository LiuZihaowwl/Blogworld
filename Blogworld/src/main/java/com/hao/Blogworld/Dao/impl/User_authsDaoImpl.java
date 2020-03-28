package com.hao.Blogworld.Dao.impl;

import com.hao.Blogworld.Dao.User_authsDao;
import com.hao.Blogworld.Entity.User;
import com.hao.Blogworld.Entity.User_auths;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class User_authsDaoImpl implements User_authsDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public int add(User_auths u){
        return jdbcTemplate.update("insert into user_auths(uu_id, u_id,credential,ifverified) values(?, ?, ?,?)",null,u.getU_id(),u.getCredential(),u.getIfverified());
    }
    public int update(User_auths u){
        return 1;
    }
    public User_auths queryUserByU_id(Long u_id){
        String sql = "SELECT * FROM user_auths WHERE u_id = ?";
        User_auths u = jdbcTemplate.queryForObject(sql, new UserauthosRowMapper(), u_id);
        return u;
    }
}
