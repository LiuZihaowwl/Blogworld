package com.hao.Blogworld.Dao.impl;

import com.hao.Blogworld.Dao.BlogDao;
import com.hao.Blogworld.Entity.Blog;
import com.hao.Blogworld.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BlogDaoImpl implements BlogDao {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public int add(Blog blog){
        return jdbcTemplate.update("insert into blog(b_id, b_title,u_id,b_body,watch,nice) values(?, ?, ?,?,?,?)",null,blog.getB_title(),blog.getU_id(),blog.getB_body(),blog.getWatch(),blog.getNice());
    }
    @Override
    public int update(Blog blog)
    {
        return 1;
    }
    @Override
    public int delete(Long id){
        String sql = "delete from blog where u_id = ?";
        return jdbcTemplate.update(sql,id);
    }
    @Override
    public   Blog queryBlogById(Long id){
        String sql = "SELECT * FROM blog WHERE b_id = ?";
        Blog blog = jdbcTemplate.queryForObject(sql, new BlogRowMap(), id);
        return blog;
    }
    @Override
    public List<Blog> queryAllBlog(Long id) {
        String sql = "SELECT * FROM blog WHERE u_id = ?";
        List<Blog> blogs = jdbcTemplate.query(sql, new Object[]{id}, new BlogRowMap());
        return blogs;
    }

}
