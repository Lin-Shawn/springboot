package com.myproject.shawn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/** 
 * @author linx
 * @date 2019年4月22日下午2:59:52
 */
@SpringBootApplication
public class ShawnApplication extends SpringBootServletInitializer {
	
	public static void main(String[] args) {
		/*SpringApplication springApplication = new SpringApplication(ShawnApplication.class);
		springApplication.setBannerMode(Mode.OFF);
		springApplication.run(args);*/
		SpringApplication.run(ShawnApplication.class, args);
	}
	
}
