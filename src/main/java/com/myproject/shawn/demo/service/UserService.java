package com.myproject.shawn.demo.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.myproject.shawn.demo.entity.User;

/** 
 * @author linx
 * @date 2019年4月22日下午5:22:22
 */
public interface UserService {
	List<User> findAll();
	List<User> findUsersByName(User user);
	PageInfo<User> findUsersByPage(Integer pageNum,Integer rows);
}
