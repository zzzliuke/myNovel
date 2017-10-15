package com.myNovel.admin.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.myNovel.admin.pojo.TestUser;
import com.myNovel.admin.service.TestService;

@RestController
@RequestMapping("/test")
public class TestController {

	@Autowired
	private TestService testService;

	@RequestMapping
	public ModelAndView say(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("-你好世界!-");
		ModelAndView mv = new ModelAndView();
		// 设置返回的视图
		mv.addObject("msg", "张三");
		mv.setViewName("/index");

		return mv;
	}

	@GetMapping("/list")
	public List<TestUser> select() {
		List<TestUser> list = new ArrayList<TestUser>();
		list = testService.selectByPage(2, 2);
		return list;
	}

	@PostMapping("/date")
	public ModelAndView getCurrentDate(@Param(value = "name") String name) {
		System.out.println(name);
		ModelAndView mv = new ModelAndView();
		// 设置返回的视图
		mv.addObject("msg", "张三");
		mv.setViewName("/index");

		return mv;
	}

	@GetMapping("/date1")
	public List<String> getCurrentDate1(@Param(value = "name") String name) {
		ArrayList<String> list = new ArrayList<String>();
		list.add(name);
		list.add("刘可");
		return list;
	}

	@GetMapping("/save")
	public void insert() {

		TestUser testUser = new TestUser("刘可1", 23, "男");
		testService.insertSelective(testUser);

	}
	
	@GetMapping("/testShiwu")
	public void testshiwu(){
		
		TestUser testUser = new TestUser("刘可001", 23, "男");
		TestUser testUser1 = new TestUser("刘可002", 23, "男");
		List<TestUser> list = new ArrayList<TestUser>();
		list.add(testUser);
		list.add(testUser1);
		testService.insertList(list);
	}

}
