package com.myproject.shawn.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.myproject.shawn.demo.entity.User;
import com.myproject.shawn.demo.service.UserService;

/** 
 * @author linx
 * @date 2019年4月22日下午5:25:58
 */
@RestController
@RequestMapping("user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("list")
	public List<User> queryUserAll(){
		return userService.findAll();
	}
	@RequestMapping("name")
	public List<User> queryUserAllByName(User user){
		return userService.findUsersByName(user);
	}
	
	@RequestMapping("list/{pageNum}/{rows}")
	public PageInfo<User> queryUsersByPage(@PathVariable Integer pageNum,@PathVariable Integer rows){
		return userService.findUsersByPage(pageNum, rows);
	}
}
