package com.myNovel.admin.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myNovel.admin.pojo.TestUser;
import com.myNovel.admin.service.TestService;

@Service
@Transactional(readOnly=false)
public class TestserviceImpl extends BaseServiceImpl<TestUser> implements TestService {

	public String queryCurentDate() {
		// TODO Auto-generated method stub
		return "现在的时间是11";
	}

	public void insertList(List<TestUser> list) {
		for (TestUser testUser : list) {
			this.insertSelective(testUser);
		}
	}
	
}
