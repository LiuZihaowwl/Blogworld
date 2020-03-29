package com.hao.Blogworld.Service.Impl;

import com.hao.Blogworld.Dao.cluster.BlogDao;
import com.hao.Blogworld.Entity.Blog;
import com.hao.Blogworld.Service.BlogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;


@Service
public class BlogServiceImpl implements BlogService {
    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(BlogServiceImpl.class);
    @Autowired
    BlogDao blogDao;
    @Autowired
    private RedisTemplate redisTemplate;
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
        // 从缓存中获取博客信息
        String key = "author_"+id;
        ValueOperations<String, List<Blog>> operations = redisTemplate.opsForValue();


        // 缓存存在
        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
            List<Blog> blogs = operations.get(key);
            for (Blog blog:blogs) {
                LOGGER.info("BlogServiceImpl.queryAllById() : 从缓存中获取了博客 >> " + blog.toString());
            }

            return blogs;
        }

        // 从 DB 中获取城市信息
        List<Blog> blogs = blogDao.queryAllBlog(id);

        // 插入缓存
        operations.set(key, blogs, 10, TimeUnit.SECONDS);
        for (Blog blog:blogs) {
            LOGGER.info("BlogServiceImpl.queryAllById() : 插入缓存 >> " + blog.toString());
        }
        return blogs;
    }
}
