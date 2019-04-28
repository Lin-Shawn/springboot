package com.myproject.shawn.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myproject.shawn.demo.dao.UserDao;
import com.myproject.shawn.demo.entity.User;
import com.myproject.shawn.demo.service.UserService;

/** 
 * @author linx
 * @date 2019年4月22日下午5:23:28
 */
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public List<User> findAll() {
		return this.userDao.findAll();
	}

	@Override
	public List<User> findUsersByName(User user) {
		return this.userDao.findUsersByName(user);
	}
	@Override
	public PageInfo<User> findUsersByPage(Integer pageNum,Integer rows){
		//分页设置
		PageHelper.startPage(pageNum, rows);
		//获取总数据
		List<User> list = this.userDao.findAll();
		//分页数据查询
		PageInfo<User> pageInfo = new PageInfo<User>(list);
		return pageInfo;
	}

}
