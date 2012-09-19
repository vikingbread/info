package com.info.service;

import java.util.List;

import com.info.pojo.BalanceRecord;
import com.info.utils.PageUtil;

/** 
 * @author  Viking
 * @version 创建时间：2012-9-6 下午02:37:25 
 * 
 */
public interface BalanceRecordService {
	/**
	 * 添加新的消费记录
	 * @param record 记录
	 * @param uid 用户id
	 * @return 
	 */
	boolean insertRecord(BalanceRecord record, long uid);
	/**
	 * 工具用户id分页查询记录
	 * @param page 分页工具
	 * @param id 用户id
	 * @return 用户列表
	 */
	List<BalanceRecord>  queryRecordsPageById(PageUtil page, long id);  
}
