package com.jiewang.dao.base;

import java.util.List;
import java.util.Map;

public interface BaseDao<T> {

	int insertEntry(T t);

	/**
	 * 删除对象,主键
	 * @param key
	 * @return 影响条数
	 */
	int deleteByKey(Object key);

	/**
	 * 删除对象,条件
	 * @param condition
	 * @return 影响条数
	 */
	int deleteByCondition(T condition);
	
	/**
	 * 更新对象,条件主键ID
	 * @param t
	 * @return 影响条数
	 */
	int updateByKey(T t);

	/**
	 * 查询对象,条件主键
	 * @param key
	 * @return
	 */
	T selectEntryByKey(Object key);

	/**
	 * 查询对象,只要不为NULL与空则为条件
	 * @param t
	 * @return
	 */
	List<T> selectEntryList(T t);

	/**
	 * 查询对象总数
	 * @param t
	 * @return
	 */
	Integer selectEntryListCount(T t);
}
