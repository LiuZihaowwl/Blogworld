package com.hao.Blogworld.Dao.impl;

import com.hao.Blogworld.Dao.UserDao;
import com.hao.Blogworld.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import javax.jws.soap.SOAPBinding;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public int add(User user) {
        SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
        sdf.applyPattern("yyyy-MM-dd");// a为am/pm的标记
        Date date = new Date();// 获取当前时间
        System.out.println(user.getSignal());
        String gender = null;
        gender = user.getGender().equals("0") ? "男":"女";
        String sql = "insert into `user`(`u_id`, `u_name`,`gender`,`birthday`,`phone`,`email`,`signal`) values(?,?,?,?,?,?,?)";
        return jdbcTemplate.update(sql,null,user.getU_name(),gender,sdf.format(date),user.getPhone(),user.getEmail(),user.getSignal());

    }
    @Override
    public int update(User user){
        return 1;
    }
    @Override
    public User queryUserByPhone(String phone){
        String sql = "SELECT * FROM user WHERE phone = ?";
        User user = jdbcTemplate.queryForObject(sql, new MyRowMapper(), phone);
        return user;
    }
    @Override
    public User queryUserById(Long id){
        String sql = "SELECT * FROM user WHERE u_id = ?";
        User user = jdbcTemplate.queryForObject(sql, new MyRowMapper(), id);
        return user;
    }

    private User generateEntity(SqlRowSet rs) {
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

