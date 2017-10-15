package com.myNovel.admin.service;

import java.util.List;

import com.myNovel.admin.pojo.TestUser;

public interface TestService extends BaseService<TestUser> {
	
	public String queryCurentDate();

	public void insertList(List<TestUser> list);
}
