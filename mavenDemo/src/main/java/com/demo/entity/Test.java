package com.demo.entity;

public class Test {
	private Integer id;
	
	private String name;
	
	private Float score;
	
	public Test() {}
	
	public Test(Integer Id , String name , Float score) { 
		super();
		this.id = Id;
		this.name = name;
		this.score = score;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getScore() {
		return score;
	}

	public void setScore(Float score) {
		this.score = score;
	}

	
}
