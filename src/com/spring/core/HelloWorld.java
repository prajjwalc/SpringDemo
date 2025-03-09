package com.spring.core;

import org.springframework.stereotype.Component;

@Component
public class HelloWorld {
	String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public void helloWorldInitMethod() {
		System.out.println("HelloWorldInitMethod...");
	}
	
	public void destroyHelloWorldMethod() {
		System.out.println("destroyHelloWorldMethod . . .");
	}
}
