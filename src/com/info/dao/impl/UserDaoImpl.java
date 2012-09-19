package com.info.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;
import com.info.dao.UserDao;
import com.info.pojo.User;
import com.info.utils.MD5Util;
import com.info.utils.PageUtil;

/**
 * @author Viking
 * @version 创建时间：2012-8-17 下午09:01:59
 * 
 */
@Repository("userDao")
public class UserDaoImpl implements UserDao {
	private SqlMapClientTemplate sqlMapClientTemplate;

	@Override
	public boolean changePasswd(String uname, String newPasswd) {
		boolean result;
		Map<String, String> map = new HashMap<String, String>(2);
		map.put("name", uname);
		map.put("passwd", newPasswd);
		int ret = sqlMapClientTemplate.update("user.updateUserPasswd", map);
		if(ret>0){
			result = true;
		}else{
			result = false;
		}
		return result;
	}
	
	@Override 
	public int updateUser(User user) {
		Map<String, String> map = new HashMap<String, String>(2);
		map.put("authority", user.getAuthority());
		map.put("name",user.getName());
		sqlMapClientTemplate.update("user.updateUserAuthority", map);
		return sqlMapClientTemplate.update("user.updateUserInfo", user);
	}
	
	@Override
	public void disableUser(long id) {
		sqlMapClientTemplate.update("user.disableUser", id);
	}

	@Override
	public void enableUser(long id) {
		sqlMapClientTemplate.update("user.enableUser", id);
	}

	@Override
	public User queryUserByName(String name) {

		return (User) sqlMapClientTemplate.queryForObject(
				"user.queryUserByName", name);
	}

	@Override
	public int queryUserCount() {
		return (Integer) sqlMapClientTemplate
				.queryForObject("user.getUserCount");
	}

	@Override
	public List<User> queryAllUsersByPage(PageUtil page) {
		List<User> list = sqlMapClientTemplate.queryForList(
				"user.queryAllUsersByPage", page.getSkipCount(),
				page.getPageSize());
		return list;
	}

	@Override
	public boolean addUser(User user) {
		sqlMapClientTemplate.insert("user.addUser", user);
		return true;
	}

	@Override
	public void addAuthorities(User user) {
		sqlMapClientTemplate.insert("user.addAuthorities", user);
	}

	@Override
	public boolean delUser(long id) {
		User user = (User) sqlMapClientTemplate.queryForObject(
				"user.queryUserById", id);
		if (user == null) {
			throw new IllegalArgumentException("不存在该id为"+id+"的用户");
		}
		sqlMapClientTemplate.delete("user.deleteAuthority", user.getName());
		sqlMapClientTemplate.delete("user.deleteUser", id);
		return true;
	}

	@Override
	public User queryUserById(long id) {
		User user = (User) sqlMapClientTemplate.queryForObject(
				"user.queryUserById", id);
		if(user!=null){
			String authority = (String) sqlMapClientTemplate.queryForObject("user.queryUserAuthority", user.getName());
			user.setAuthority(authority);
		}
		return user;
	}

	@Override
	public void updateBalance(float balance, long id) {
		Map params = new HashMap(2);
		params.put("id", id);
		params.put("balance", balance);
		sqlMapClientTemplate.update("user.updateBalance", params);
	}

	@Override
	public float queryBalanceById(long id) {

		Float balance = (Float) sqlMapClientTemplate.queryForObject(
				"user.queryBalanceById", id);
		if (balance == null) {
			return 0;
		}
		return balance;
	}

	@Override
	public int updateLoginInfo(User user) {
		return sqlMapClientTemplate.update("user.updateLoginInfo", user);

	}

	@Override
	public User checkUser(String uname, String upasswd) {
		Map map = new HashMap(2);
		map.put("name", uname);
		map.put("passwd", upasswd);
		return (User) sqlMapClientTemplate.queryForObject(
				"user.queryUserByNameAndPasswd", map);
	}

	public SqlMapClientTemplate getSqlMapClientTemplate() {
		return sqlMapClientTemplate;
	}

	@Resource
	public void setSqlMapClientTemplate(
			SqlMapClientTemplate sqlMapClientTemplate) {
		this.sqlMapClientTemplate = sqlMapClientTemplate;
	}
}
