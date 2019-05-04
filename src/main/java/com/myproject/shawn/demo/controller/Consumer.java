package com.myproject.shawn.demo.controller;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/** 
 * @author linx
 * @date 2019年5月4日下午3:09:54
 */
@Component
public class Consumer {
	//接受消息方法
	@JmsListener(destination = "itcast.queue")
	public void readMessage(String text){
		System.out.println("接受到的消息是："+text);
	}
}
