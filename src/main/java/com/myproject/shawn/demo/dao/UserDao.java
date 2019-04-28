package com.myproject.shawn.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.myproject.shawn.demo.entity.User;

/** 
 * @author linx
 * @date 2019年4月22日下午5:20:07
 */
@Mapper
public interface UserDao{
	List<User> findAll();
	
	List<User> findUsersByName(User user);
}
