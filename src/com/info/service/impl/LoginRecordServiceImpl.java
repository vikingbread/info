package com.info.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.annotation.security.RolesAllowed;

import org.springframework.stereotype.Component;

import com.info.dao.LoginRecordDao;
import com.info.dao.UserDao;
import com.info.pojo.LoginRecord;
import com.info.pojo.User;
import com.info.service.LoginRecordService;
import com.info.utils.PageUtil;

/**
 * @author Viking
 * @version 创建时间：2012-9-15 上午09:23:54
 * 
 */
@Component("loginRecordService")
public class LoginRecordServiceImpl implements LoginRecordService {
	private LoginRecordDao loginRecordDao;
	private UserDao userDao;
	
	@RolesAllowed(value = { "ROLE_ADMIN", "ROLE_USER" })
	public List<LoginRecord> queryAllLoginRecords(PageUtil page, long uid) {
		List<LoginRecord> list = null;
		Map map = new HashMap();
		if (uid > 0) {//id<0 表示查询所有记录
			map.put("uid", uid);
		}
		int count = loginRecordDao.getLoginRecordCount(map);
		page.setAllRecord(count);// 设置总条数

		int pageSize = page.getPageSize();
		int skipCount = (page.getPageNow() - 1) * pageSize;
		page.setSkipCount(skipCount);
		list = loginRecordDao.queryAllLoginRecords(page, map);
		if(list ==null 	){
			list = new ArrayList<LoginRecord>();
		}
		return list;
	}
	@Override
	public boolean addLoginRecord(LoginRecord loginRecord) {
		User queriedUser = userDao.queryUserById(loginRecord.getUser().getId());
		if(queriedUser==null){
			return false;
		}
	    	loginRecordDao.addLoginRecord(loginRecord);
		return true;
	}
	@Resource
	public void setLoginRecordDao(LoginRecordDao loginRecordDao) {
		this.loginRecordDao = loginRecordDao;
	}
	@Resource
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
}
