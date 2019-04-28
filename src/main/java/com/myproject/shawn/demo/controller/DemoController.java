package com.myproject.shawn.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** 
 * @author linx
 * @date 2019年4月22日下午3:45:22
 */
@RestController
public class DemoController {
	@RequestMapping("helloInfo")
	public String helloInfo(){
		return "Hello world!!";
	}
}
