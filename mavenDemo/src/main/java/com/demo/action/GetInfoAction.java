package com.demo.action;

import com.demo.entity.Test;
import com.demo.service.TestService;

public class GetInfoAction {
	
	private Integer Id;
	private Test test;
	private TestService testService;
	
	
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public Test getTest() {
		return test;
	}
	public void setTest(Test test) {
		this.test = test;
	}
	public TestService getTestService() {
		return testService;
	}
	public void setTestService(TestService testService) {
		this.testService = testService;
	}
	
	public String execute() {
		return "tologin";
	}
	
	public String quary() {
		test = testService.qureyById(Id);
		System.out.println(test.getName());
		return "tologin";
	}
}
