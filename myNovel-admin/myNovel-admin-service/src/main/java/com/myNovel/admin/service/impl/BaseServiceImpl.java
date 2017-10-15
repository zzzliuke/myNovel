package com.myNovel.admin.service.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.myNovel.admin.service.BaseService;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

/**
 * 基础的业务层操作接口实现类
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2017年5月23日 上午9:54:35
 * @version 1.0
 */
@SuppressWarnings("unchecked")
public class BaseServiceImpl<T> implements BaseService<T> {
	
	/** 注入通用Mapper */
	@Autowired
	private Mapper<T> mapper;
	/** 定义T的class类型 */
	private Class<T> entityClass;
	
	/** 定义构造器初始化entityClass */
	public BaseServiceImpl(){
		/** 获取父接口中的泛型参数类型 */
		ParameterizedType parameterizedType =  
				(ParameterizedType)this.getClass().getGenericSuperclass();
		/** 获取实际的参数类型 */
		entityClass = (Class<T>)parameterizedType.getActualTypeArguments()[0];
	}
	
	/** 选择性的添加 */
	public void insertSelective(T entity){
		mapper.insertSelective(entity);
	}
	/** 选择性的修改 */
	public void updateSelective(T entity){
		mapper.updateByPrimaryKeySelective(entity);
	}
	/** 根据主键id删除 */
	public void delete(Serializable id){
		mapper.deleteByPrimaryKey(id);
	}
	/** 多个id批量删除 */
	public void deleteAll(String idField, Serializable[] ids){
		// delete from 表 where id in(?,?,?)
		/** 创建示范对象 */
		Example example = new Example(entityClass);
		/** 创建条件对象 */
		Criteria criteria = example.createCriteria();
		/** 生成条件 */
		criteria.andIn(idField, Arrays.asList(ids));
		/** 根据条件删除 */
		mapper.deleteByExample(example);
	}
	
	/** 根据主键id查询 */
	public T selectOne(Serializable id){
		return mapper.selectByPrimaryKey(id);
	}
	
	/** 查询全部 */
	public List<T> selectAll(){
		return mapper.selectAll();
	}
	
	/** 等于号条件查询 */
	public List<T> selectByWhere(T entity){
		return mapper.select(entity);
	}
	
	/** 分页查询 */
	public List<T> selectByPage(Integer pageNum, Integer pageSize){
		/** 开始分页 */
		PageHelper.startPage(pageNum, pageSize);
		return mapper.selectAll();
	}
	/** 等于号条件统计查询 */
	public Integer countByWhere(T entity){
		return mapper.selectCount(entity);
	}
}