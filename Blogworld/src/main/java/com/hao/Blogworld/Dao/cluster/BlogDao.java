package com.hao.Blogworld.Dao.cluster;

import com.hao.Blogworld.Entity.Blog;
import com.hao.Blogworld.Entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface BlogDao {
    int add(Blog blog);
    int update(Blog blog);
    int delete(Long id);
    Blog queryBlogById(Long id);

    @Select("select * from blog where u_id = #{u_id}")
    @Results({
            @Result( property="b_id", column="b_id"),
            @Result( property="b_title", column="b_title"),
            @Result( property="u_id", column="u_id"),
            @Result( property="b_body", column="b_body"),
            @Result( property="watch", column="watch"),
            @Result( property="nice", column="nice"),

    })
    List<Blog> queryAllBlog(Long u_id);
}
