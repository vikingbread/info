package dao;

import java.sql.Timestamp;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.info.dao.UserDao;
import com.info.pojo.User;
import com.info.utils.MD5Util;

public class UserTester extends BaseTest {
	@Test
	public void insert() {
		User user = new User();
		user.setName("admin");
		user.setEmail("hah@gmail.com");
		user.setPasswd(MD5Util.getMD5("123456"));
		user.setSno("s2099");
		user.setSclass("zdh092");
		user.setRecentlyLoginIp("dddd.fff");
		user.setCreatetime(new java.sql.Timestamp(System.currentTimeMillis()));
		int obj = sqlMapClientTemplate.update("insertUser", user);
		System.out.println(obj);
		updateLoginInfo();
		throw new RuntimeException();
	}
	@Test
	public void queryUserById(){
		UserDao userDao = getBean("userDao");
		User user = userDao.queryUserById(2682683403L);
		System.out.println(user);
	}
	@Test
	public void queryUserByName() {
		User user = (User) sqlMapClientTemplate.queryForObject("user.queryUserByName",
				"admin");
		Assert.assertNotNull(user);
	}

	@Test
	public void updateLoginInfo() {
		User user = new User();
		user.setId(3);
		user.setRecentlyLoginTime(new Timestamp(System.currentTimeMillis()));
		user.setRecentlyLoginIp("192.168.1.2");
		int obj = sqlMapClientTemplate.update("user.updateLoginInfo", user);
		System.out.println(obj);
	}
//	@Test
//	public void getUserByName(){
//		User user = (User) sqlMapClientTemplate.queryForObject("usersByUsernameQuery", "admin");
//		System.out.println(user);
//		Assert.assertNotNull(user);
//	}
	@Test
	public void authoritiesByUsernameQuery(){
		User user = (User) sqlMapClientTemplate.queryForObject("usersByUsernameQuery", "admin");
		System.out.println(user);
	}
	
}
