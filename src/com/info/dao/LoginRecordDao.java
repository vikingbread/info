package com.info.dao;

import java.util.List;
import java.util.Map;
import com.info.pojo.LoginRecord;
import com.info.utils.PageUtil;

/** 
 * @author  Viking
 * @version 创建时间：2012-9-15 上午09:51:32 
 * 用户登陆信息持久化类
 * 不提供删除操作
 */
public interface LoginRecordDao {
	/**
	 * 根据用户id分页查询用户登陆记录
	 * @param page 分页工具
	 * @param map map 对应某个用户id的key-value 查询所有时为空
	 * @return 登陆信息列表
	 */
	List<LoginRecord> queryAllLoginRecords(PageUtil page,Map<String, String> map);
	
	/**
	 * 添加用户登陆记录
	 * @param loginRecord 登陆记录
	 */
	void addLoginRecord(LoginRecord loginRecord);
	/**
	 * 查询用户登陆记录
	 * @param map 对应某个用户id的key-value 查询所有时为空
	 * @return
	 */
	public int getLoginRecordCount(Map<String, String> map);
}
