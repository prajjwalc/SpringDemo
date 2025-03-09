package com.spring.mvc;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Welcome {

	@NotEmpty(message="Please input vlue for subject field")
	@Size(min=5, message="Subject must be >=5 in size")
	String subject;
	String message;

	
	public Welcome() {
		super();
	}

	public Welcome(String message) {
		super();
		this.message = message;
	}

	
	
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Welcome [subject=" + subject + ", message=" + message + "]";
	}
	
	
}
