package com.spring.core;

import org.springframework.stereotype.Component;

@Component
public class Dept {

	private String name;
	private String id;
	
	public String printMyData() {
		System.out.println("Dept - printing my data");
		
		return "Done - Dept";
	}
}
