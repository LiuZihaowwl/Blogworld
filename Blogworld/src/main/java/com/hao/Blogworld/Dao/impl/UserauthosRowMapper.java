package com.hao.Blogworld.Dao.impl;

import com.hao.Blogworld.Entity.User;
import com.hao.Blogworld.Entity.User_auths;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserauthosRowMapper implements RowMapper<User_auths> {
    @Override
    public User_auths mapRow(ResultSet rs, int i) throws SQLException {
        User_auths u = new User_auths();
        u.setUu_id(rs.getLong("uu_id"));
        u.setUu_id(rs.getLong("uu_id"));
        u.setCredential(rs.getString("credential"));
        u.setIfverified(rs.getString("ifverified"));
        return u;
    }
}
