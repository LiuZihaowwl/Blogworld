package com.hao.Blogworld.Dao.master;

import com.hao.Blogworld.Entity.User;
import com.hao.Blogworld.Entity.User_auths;
import org.apache.ibatis.annotations.*;

@Mapper
public interface User_authsDao {
    int add(User_auths u);
    int update(User_auths u);


    @Select("select * from user_auths where u_id =#{u_id}")
    @Results({
            @Result( property="uu_id", column="uu_id"),
            @Result(property="u_id",column="u_id"),
            @Result (property="credential" ,column="credential"),
            @Result (property="ifverified",column="ifverified" ) ,
            })
    User_auths queryUserByU_id(@Param("u_id") Long u_id);
}
