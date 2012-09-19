package com.info.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.annotation.security.RolesAllowed;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.info.dao.BalanceRecordDao;
import com.info.dao.UserDao;
import com.info.pojo.BalanceRecord;
import com.info.service.BalanceRecordService;
import com.info.utils.PageUtil;

/**
 * @author Viking
 * @version 创建时间：2012-9-6 下午02:55:12
 * 
 */
@Component("balanceRecordService")
public class BalanceRecordServiceImpl implements BalanceRecordService {

	private BalanceRecordDao balanceRecordDao;
	private UserDao userDao;

	@RolesAllowed(value = { "ROLE_ADMIN", "ROLE_USER" })
	public List<BalanceRecord> queryRecordsPageById(PageUtil page, long uid) {
		
		Map map = new HashMap();
		map.put("uid", uid);
		int count = balanceRecordDao.queryRecordCount(map);
		page.setAllRecord(count);//设置总条数
		
		int pageSize = page.getPageSize();
		int skipCount = (page.getPageNow()-1)*pageSize;
		page.setSkipCount(skipCount);
		return balanceRecordDao.queryAllRecordPageById(page,uid);
	}

	@Transactional
	public boolean insertRecord(BalanceRecord record, long uid) {
		float balance = userDao.queryBalanceById(uid);
		if (record.getOtype() == 0) {
			balance = balance + record.getBalance();
		} else {
			balance = balance - record.getBalance();
		}
		if (balance < 0) {
		//	throw new IllegalArgumentException("余额不足");
			return false;
		}
		userDao.updateBalance(balance, uid);
		balanceRecordDao.insertRecord(record, uid);
		
		return true;
	}

	// getter & setter ~~~~~

	@Resource
	public void setBalanceRecordDao(BalanceRecordDao balanceRecordDao) {
		this.balanceRecordDao = balanceRecordDao;
	}

	@Resource
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
