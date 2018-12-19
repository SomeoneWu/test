package com.demo.service;

import org.springframework.transaction.annotation.Transactional;

import com.demo.dao.GetInfo;
import com.demo.entity.Test;
import com.demo.service.TestService;

@Transactional
public class TestServiceImpl implements TestService {
	
	private GetInfo getInfo;
	

	public GetInfo getGetInfo() {
		return getInfo;
	}


	public void setGetInfo(GetInfo getInfo) {
		this.getInfo = getInfo;
	}


	@Override
	public Test qureyById(Integer Id) {
		// TODO Auto-generated method stub
		return getInfo.quaryByID(Id);
	}

}
