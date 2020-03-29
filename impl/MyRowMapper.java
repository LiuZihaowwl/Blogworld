package com.hao.Blogworld.Dao.impl;

import com.hao.Blogworld.Entity.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MyRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs,int i) throws SQLException{
        User user = new User();
        user.setU_id(rs.getLong("u_id"));
        user.setU_name(rs.getString("u_name"));
        user.setGender(rs.getString("gender"));
        user.setBirthday(rs.getDate("birthday"));
        user.setPhone(rs.getString("phone"));
        user.setEmail(rs.getString("email"));
        user.setSignal(rs.getString("signal"));
        return user;
    }
}
