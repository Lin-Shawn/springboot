package com.myproject.shawn;

import javax.jms.Queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

/** 
 * @author linx
 * @date 2019年4月22日下午2:59:52
 */
@SpringBootApplication
@EnableCaching
public class ShawnApplication extends SpringBootServletInitializer {
	
	public static void main(String[] args) {
		/*SpringApplication springApplication = new SpringApplication(ShawnApplication.class);
		springApplication.setBannerMode(Mode.OFF);
		springApplication.run(args);*/
		SpringApplication.run(ShawnApplication.class, args);
	}
	
	@Bean
	public Queue queue(){
		return new ActiveMQQueue("itcast.queue");
	}
	
}
