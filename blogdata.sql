CREATE DATABASE `blog` 
USE `blogworld`;

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `u_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `u_name` varchar(20) NOT NULL COMMENT '昵称',
  `gender` varchar(2) NOT NULL COMMENT '用户性别',
  `birthday` date NOT NULL COMMENT '用户出生日期',
  `phone` char(11) NOT NULL  COMMENT '用户手机号',
  `email` varchar(20) NOT NULL  COMMENT '用户邮箱',
  `signal` varchar(60) NOT NULL  COMMENT '个性签名',
  PRIMARY KEY (`u_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1029 DEFAULT CHARSET=utf8;

CREATE TABLE `blog` (
  `b_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '博客ID',
  `b_title` varchar(30) NOT NULL COMMENT '标题',
  `u_id` bigint(20) NOT NULL COMMENT '用户ID',
  `b_body` TEXT NOT NULL COMMENT '博客内容',
  `watch` bigint(20) NOT NULL  COMMENT '浏览数',
  `nice` bigint(10) NOT NULL  COMMENT '点赞数',
  PRIMARY KEY (`b_id`),
  FOREIGN KEY (`u_id`) REFERENCES user(`u_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1029 DEFAULT CHARSET=utf8;

CREATE TABLE `user_auths` (
  `uu_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '授权表ID',
  `u_id` bigint(20) NOT NULL COMMENT '用户ID',
  `credential` varchar(30) NOT NULL COMMENT '用户密码',
  `ifverified` varchar(4) NOT NULL  COMMENT '是否被验证',
  PRIMARY KEY (`uu_id`),
  FOREIGN KEY (`u_id`) REFERENCES user(`u_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1029 DEFAULT CHARSET=utf8;

