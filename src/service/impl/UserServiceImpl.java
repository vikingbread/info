package com.info.service.impl;

import java.util.List;
import javax.annotation.Resource;
import javax.annotation.security.RolesAllowed;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.info.dao.UserDao;
import com.info.pojo.User;
import com.info.service.UserService;
import com.info.utils.MD5Util;
import com.info.utils.PageUtil;

/**
 * @author Viking
 * @version 创建时间：2012-9-6 下午02:16:45
 * 
 */
@Component("userService")
public class UserServiceImpl implements UserService {
	private UserDao userDao;

	@Override
	public boolean changeUserPasswd(String uname, String passwd,
			String newPasswd) {
		boolean result;
		User queriedUser = userDao.checkUser(uname, MD5Util.getMD5(passwd));
		if(queriedUser==null){
			result = false;
		}else{
			result = userDao.changePasswd(uname,MD5Util.getMD5(newPasswd));
		}
		return result;
	}

	@Override
	@RolesAllowed(value = { "ROLE_ADMIN" })
	public boolean enableUser(long id) {
		boolean result;
		User queriedUser = userDao.queryUserById(id);
		if (queriedUser == null) {
			result = false;
		} else {
			userDao.enableUser(id);
			result = true;
		}
		return result;
	}

	@Override
	@RolesAllowed(value = { "ROLE_ADMIN" })
	public boolean disableUser(long id) {
		boolean result = true;
		User queriedUser = userDao.queryUserById(id);
		if (queriedUser == null) {
			result = false;
		} else {
			userDao.disableUser(id);
			result = true;
		}
		return result;
	}

	@Override
	@RolesAllowed(value = { "ROLE_ADMIN" })
	public List<User> queryAllUsersByPage(PageUtil page) {
		int count = userDao.queryUserCount();
		page.setAllRecord(count);// 设置总条数
		int pageSize = page.getPageSize();
		int skipCount = (page.getPageNow() - 1) * pageSize;
		page.setSkipCount(skipCount);
		List<User> list = userDao.queryAllUsersByPage(page);
		return list;
	}

	@Transactional
	@Override
	@RolesAllowed(value = { "ROLE_ADMIN" })
	public boolean addUser(User user) {
		boolean result;
		User queriedUser = userDao.queryUserById(user.getId());// 查id号是否存在
		if (queriedUser == null) {
			queriedUser = userDao.queryUserByName(user.getName());// 查用户名是否存在
																	// 这里进行大小写模糊查询
		}

		if (queriedUser != null) {
			result = false;
		} else {
			userDao.addUser(user);
			userDao.addAuthorities(user);
			result = true;
		}
		return result;
	}

	@Override
	@Transactional
	@RolesAllowed(value = { "ROLE_ADMIN" })
	public boolean delUser(long id) {
		boolean result = true;
		User queriedUser = userDao.queryUserById(id);
		if (queriedUser == null) {
			result = false;
		} else {
			userDao.delUser(id);
			result = true;
		}
		return result;
	}

	@Override
	@Transactional
	@RolesAllowed(value = { "ROLE_ADMIN" })
	public boolean updateUser(User user) {
		boolean result = false;
		User queriedUser = userDao.queryUserById(user.getId());
		if (!queriedUser.getName().equals(user.getName())) {// 正常情况下是相等的
			result = false;
		}
		int id = userDao.updateUser(user);
		if (id > 0) {
			result = true;
		}
		return result;
	}

	@Override
	public boolean checkUser(String uname, String upasswd) {
		boolean result;
		User user = userDao.checkUser(uname, MD5Util.getMD5(upasswd));
		if (user == null) {
			result = false;
		} else {
			result = true;
		}
		return result;
	}

	@Override
	public User login(String uname, String upasswd) {
		User user = userDao.checkUser(uname, MD5Util.getMD5(upasswd));
		return user;
	}

	@Override
	public void updateLoginInfo(User user) {
		User queriedUser = userDao.queryUserById(user.getId());
		if (queriedUser == null) {
			return;
		}
		userDao.updateLoginInfo(user);
	}

	@Override
	public User queryUserById(long id) {
		return userDao.queryUserById(id);
	}

	@Override
	public String getUserInString(long id) {// 根据用户协议转换字符串
		User user = userDao.queryUserById(id);

		StringBuilder sb = new StringBuilder("80,");
		String idStr = new Long(user.getId()).toString();
		sb.append(idStr.charAt(idStr.length() - 1)).append(",");
		sb.append(user.getSclass()).append(",80");

		return sb.toString();
	}

	public UserDao getUserDao() {
		return userDao;
	}

	// ~~getter & setter
	@Resource
	@Required
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
