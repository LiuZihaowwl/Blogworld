package com.hao.Blogworld.Dao.impl;

import com.hao.Blogworld.Entity.Blog;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BlogRowMap implements RowMapper<Blog> {
    @Override
    public Blog mapRow(ResultSet rs, int i) throws SQLException {
        Blog blog = new Blog();
        blog.setB_id(rs.getLong("b_id"));
        blog.setB_title(rs.getString("b_title"));
        blog.setU_id(rs.getLong("u_id"));
        blog.setB_body(rs.getString("b_body"));
        blog.setWatch(rs.getLong("watch"));
        blog.setNice(rs.getLong("nice"));
        return blog;
    }
}
