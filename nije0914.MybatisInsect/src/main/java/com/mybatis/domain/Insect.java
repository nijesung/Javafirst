package com.mybatis.domain;

public class Insect {
	
	// 데이터베이스에서 선언한 부분을 그대로 가져와 만든다
	private Integer code;
	private String name;
	private Integer price;
	private String description;
	
	
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "Insect [code=" + code + ", name=" + name + ", price=" + price + ", description=" + description + "]";
	}
	
	
	
	

}
