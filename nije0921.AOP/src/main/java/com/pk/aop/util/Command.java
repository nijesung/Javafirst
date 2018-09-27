package com.pk.aop.util;

public class Command {
	private String name;
	private String MultipartFile;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMultipartFile() {
		return MultipartFile;
	}
	public void setMultipartFile(String multipartFile) {
		MultipartFile = multipartFile;
	}
	
	
	@Override
	public String toString() {
		return "Command [name=" + name + ", MultipartFile=" + MultipartFile + "]";
	}
	
	

}
