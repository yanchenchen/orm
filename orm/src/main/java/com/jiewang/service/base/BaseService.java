package com.jiewang.service.base;

import java.util.List;

public interface BaseService<T> {

    /**
     * 添加对象
     * @param t
     * @return
     */
    int insertEntry(T t);

    /**
     * 删除对象,主键
     * @param key 主键数组
     * @return 影响条数
     */
    int deleteByKey(Object key);

    /**
     * 按条件删除对象
     * @param condition
     * @return 影响条数
     */
    int deleteByCondition(T condition);

    /**
     * 更新对象,条件主键Id
     * @param condition 更新对象
     * @return 影响条数
     */
    int updateByKey(T condition);

    /**
     * 查询对象,条件主键
     * @param key
     * @return 实体对象
     */
    T selectEntryByKey(Object key);

    /**
     * 查询对象,只要不为NULL与空则为条件
     * @param condition 查询条件
     * @return 对象列表
     */
    List<T> selectEntryList(T condition);

}
