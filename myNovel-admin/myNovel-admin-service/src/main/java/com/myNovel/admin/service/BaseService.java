package com.myNovel.admin.service;

import java.io.Serializable;
import java.util.List;

/**
 * 基础的业务层操作接口
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2017年5月23日 上午9:52:45
 * @version 1.0
 */
public interface BaseService<T> {
	
	/** 选择性的添加 */
	void insertSelective(T entity);
	
	/** 选择性的修改 */
	void updateSelective(T entity);
	
	/** 根据主键id删除 */
	void delete(Serializable id);
	
	/** 多个id批量删除 */
	void deleteAll(String idField, Serializable[] ids);
	
	/** 根据主键id查询 */
	T selectOne(Serializable id);
	
	/** 查询全部 */
	List<T> selectAll();
	
	/** 等于号条件查询 */
	List<T> selectByWhere(T entity);
	
	/** 分页查询 */
	List<T> selectByPage(Integer pageNum, Integer pageSize);
	
	/** 等于号条件统计查询 */
	Integer countByWhere(T entity);
}
