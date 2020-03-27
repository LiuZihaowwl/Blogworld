package com.hao.Blogworld.Service.Impl;

import com.hao.Blogworld.Dao.BlogDao;
import com.hao.Blogworld.Entity.Blog;
import com.hao.Blogworld.Service.BlogService;
import com.hao.Blogworld.Service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogDao blogDao;
    @Override
    public int add(Blog blog) {
        return blogDao.add(blog);
    }
    @Override
    public int update(Blog blog) {
        return blogDao.update(blog);
    }
    @Override
    public int delete(Long id) {
        return blogDao.delete(id);
    }

    ;

    public Blog queryBlogById(Long id) {
        return blogDao.queryBlogById(id);
    }

    public List<Blog> queryAllBlog(Long id) {
        return blogDao.queryAllBlog(id);
    }
}
