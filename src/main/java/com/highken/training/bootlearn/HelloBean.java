package com.highken.training.bootlearn;

import org.springframework.stereotype.Component;

@Component
public class HelloBean {

	public void  sayHello() {
		System.out.println("Hello from bean");
	}
}
