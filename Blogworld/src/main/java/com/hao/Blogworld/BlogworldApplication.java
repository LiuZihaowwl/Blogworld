package com.hao.Blogworld;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hao.Blogworld.Dao")
public class BlogworldApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogworldApplication.class, args);
	}

}
