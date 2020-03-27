package com.hao.Blogworld.Dao;

import com.hao.Blogworld.Entity.Blog;
import com.hao.Blogworld.Entity.User;

import java.util.List;

public interface BlogDao {
    int add(Blog blog);
    int update(Blog blog);
    int delete(Long id);
    Blog queryBlogById(Long id);
    List<Blog> queryAllBlog(Long id);


}
