package com.hao.Blogworld.Service;

import com.hao.Blogworld.Entity.Blog;

import java.util.List;

public interface BlogService {
    int add(Blog blog);
    int update(Blog blog);
    int delete(Long id);
    Blog queryBlogById(Long id);
    List<Blog> queryAllBlog(Long id);
}
