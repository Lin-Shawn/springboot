package com.myproject.shawn.demo.controller;

import javax.jms.Destination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** 
 * @author linx
 * @date 2019年5月4日下午3:01:00
 */
@RestController
@RequestMapping("queue")
public class QueueController {
	
	//注入发送消息的对象
	@Autowired
	private JmsTemplate jmsTemplate;
	
	//注入消息队列
	@Autowired
	private Destination destination;
	
	//编写发送消息方法
	@RequestMapping("send/{message}")
	public String send(@PathVariable String message){
		this.jmsTemplate.convertAndSend(destination, message);
		return "消息发送成功!消息内容：" + message;
	}
}
