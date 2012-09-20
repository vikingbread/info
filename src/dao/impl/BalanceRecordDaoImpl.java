package com.info.dao.impl;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;
import com.info.dao.BalanceRecordDao;
import com.info.dao.UserDao;
import com.info.pojo.BalanceRecord;
import com.info.utils.PageUtil;

/** 
 * @author  Viking
 * @version 创建时间：2012-8-18 下午09:54:05 
 * 
 */
@Repository("balanceRecordDao")
public class BalanceRecordDaoImpl implements BalanceRecordDao {
	private SqlMapClientTemplate sqlMapClientTemplate;
	private UserDao userDao;
	@Override
	
	public void insertRecord(BalanceRecord record, long uid) {
		sqlMapClientTemplate.insert("record.insertRecord", record);
	}
	@Override
	public List<BalanceRecord> queryAllRecordPageById(PageUtil page,long uid) {
		return sqlMapClientTemplate.queryForList("record.queryRecordList", uid,page.getSkipCount(), page.getPageSize());
	}
	@Override
	public int queryRecordCount(Map parms) {
		return  (Integer) sqlMapClientTemplate.queryForObject("record.getRecordCount", parms);
	}
	
	// setter & getter ~~~~~~~
	public SqlMapClientTemplate getSqlMapClientTemplate() {
		return sqlMapClientTemplate;
	}
	@Resource
	public void setSqlMapClientTemplate(SqlMapClientTemplate sqlMapClientTemplate) {
		this.sqlMapClientTemplate = sqlMapClientTemplate;
	}
	public UserDao getUserDao() {
		return userDao;
	}
	@Resource
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
