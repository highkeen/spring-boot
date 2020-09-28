package com.highken.training.bootlearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.highken.training.bootlearn.rest.controller.HelloController;

@SpringBootApplication
@EnableWebMvc
public class BootLearnApplication {

	public static void main(String[] args) {
		ApplicationContext ac=SpringApplication.run(BootLearnApplication.class, args);
		
		HelloBean helloBean=ac.getBean(HelloBean.class);
		helloBean.sayHello();
		
		HelloController helloController=ac.getBean(HelloController.class);
		
		System.out.println(helloController.satHello());
		
	}

}
