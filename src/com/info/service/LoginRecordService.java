package com.info.service;

import java.util.List;

import com.info.pojo.LoginRecord;
import com.info.utils.PageUtil;

/**
 * @author Viking
 * @version 创建时间：2012-9-15 上午09:19:55
 * 
 */
public interface LoginRecordService {

	/**
	 * 分页查询所有用户登陆记录
	 * 
	 * @param page
	 *            分页工具
	 * @param uid
	 *            需要查询用户的id 若id<=0表示查询所有用户
	 * @return 登陆列表
	 */
	List<LoginRecord> queryAllLoginRecords(PageUtil page, long uid);
	/**
	 * 增加一条登陆记录
	 * @param loginRecord 登陆记录 
	 * @return 成功返回true 失败返回false
	 */
	boolean addLoginRecord(LoginRecord loginRecord);
}
