package com.myproject.shawn.demo.service.impl;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cache.CacheProperties.Redis;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
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
	
	@Autowired
	private RedisTemplate<String, String> redisTemplate;
	
	/* @Cacheable：添加/使用缓存
	 * @CacheEvict：删除缓存
	 * 参数value是缓存的名字，在执行的时候，会找叫这个名字的缓存使用/删除
	 * 参数key默认情况下是空串””,是Spring的一种表达式语言SpEL，我们这里可以随意指定，但是需要注意一定要加单引号
	 */
	@Override
	@Cacheable(value="userCache",key="'user.findAll'")
	public List<User> findAll() {
		System.out.println("从Mysql数据库中查询");
		return this.userDao.findAll();
	}

	@Override
	@CacheEvict(value="userCache",key="'user.findAll'")
	public List<User> findUsersByName(User user) {
		//保存数据
		this.redisTemplate.boundValueOps("redis").set("hello world!");
		//设置有效时间
		this.redisTemplate.boundValueOps("redis").expire(100, TimeUnit.SECONDS);
		//给value每次执行加一操作
		this.redisTemplate.boundValueOps("count").increment(1L);
		System.out.println("缓存清理了");
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
