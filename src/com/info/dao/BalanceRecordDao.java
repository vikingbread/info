package com.info.dao;

import java.util.List;
import java.util.Map;
import com.info.pojo.BalanceRecord;
import com.info.utils.PageUtil;

/** 
 * @author  Viking
 * @version 创建时间：2012-8-18 下午09:52:25 
 * 账户记录接口
 */
public interface BalanceRecordDao {
	/**
	 * 根据用户Id分页查询账户消费记录
	 * @param page 分页工具
	 * @param uid 用户id
	 * @return 用户记录列表
	 */
	List<BalanceRecord> queryAllRecordPageById(PageUtil page,long uid);
	/**
	 * 添加一天记录
	 * @param record 需要添加的记录
	 * @param uid    用户id
	 */
	void insertRecord(BalanceRecord record,long uid);
	/**
	 * 查询用户几率数
	 * @param parms 封装好的查询条件
	 * @return 记录数量
	 */
	int queryRecordCount(Map parms);
}
