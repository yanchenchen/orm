package com.jiewang.service.base;

import com.jiewang.dao.base.BaseDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public abstract class BaseServiceImpl<T> implements BaseService<T> {
	protected static final Logger LOGGER = LoggerFactory.getLogger(BaseServiceImpl.class);

	public abstract BaseDao<T> getDao();
	
	public int insertEntry(T t) {
		return getDao().insertEntry(t);
	}

	public int deleteByKey(Object key) {
		return getDao().deleteByKey(key);
	}

	public int deleteByCondition(T condition) {
		return getDao().deleteByCondition(condition);
	}
	
	public int updateByKey(T condition) {
		return getDao().updateByKey(condition);
	}

	public T selectEntryByKey(Object key) {
		return getDao().selectEntryByKey(key);
	}

	public List<T> selectEntryList(T condition) {
		return getDao().selectEntryList(condition);
	}

}
