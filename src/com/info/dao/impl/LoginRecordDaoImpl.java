package com.info.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Component;

import com.info.dao.LoginRecordDao;
import com.info.pojo.LoginRecord;
import com.info.utils.PageUtil;

/**
 * @author Viking
 * @version 创建时间：2012-9-15 上午09:52:46
 * 
 */
@Component("loginRecordDao")
public class LoginRecordDaoImpl implements LoginRecordDao {
	private SqlMapClientTemplate sqlMapClientTemplate;

	@Override
	public List<LoginRecord> queryAllLoginRecords(PageUtil page,
			Map<String, String> map) {

		return sqlMapClientTemplate.queryForList("loginRecord.queryRecordList",
				map, page.getSkipCount(), page.getPageSize());
	}

	@Override
	public void addLoginRecord(LoginRecord loginRecord) {
		sqlMapClientTemplate.insert("loginRecord.addRecord", loginRecord);
	}
	@Override
	public int getLoginRecordCount(Map<String, String> map) {
		return (Integer) sqlMapClientTemplate.queryForObject(
				"loginRecord.getRecordCount", map);
	}

	@Resource
	public void setSqlMapClientTemplate(
			SqlMapClientTemplate sqlMapClientTemplate) {
		this.sqlMapClientTemplate = sqlMapClientTemplate;
	}

}
