package service;

import java.sql.Timestamp;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.info.pojo.User;
import com.info.service.UserService;
import com.info.utils.MD5Util;
import com.info.utils.PageUtil;

/**
 * @author Viking
 * @version 创建时间：2012-9-13 下午05:34:36
 * 
 */
public class UserServiceTest extends BaseTester {
	@Test
	public void addUserTest() {
		UserService userService = getBeanByName("userService");
		User user = new User();
		user.setId(1234561);
		user.setName("Miss.abAse");
		user.setSex("女");
		user.setPasswd(MD5Util.getMD5("123455"));
		user.setSclass("091");
		user.setSno("43");
		user.setEmail("ema@qq.com");
		user.setBalance(10);
		user.setRecentlyLoginIp("");
		user.setAuthority("ROLE_ADMIN");
		user.setCreatetime(new Timestamp(System.currentTimeMillis()));
		userService.addUser(user);
	}

	@Test
	public void queryAllUsersByPage() {
		UserService userService = getBeanByName("userService");
		PageUtil page = new PageUtil();
		page.setPageSize(16);
		List<User> list = userService.queryAllUsersByPage(page);
		System.out.println(list.size());
		Assert.assertNotNull(list);
	}

	@Test
	public void testableUser() {
		UserService userService = getBeanByName("userService");
		// userService.disableUser(2682685451L);
		userService.enableUser(2682685451L);
	}

	@Test
	public void testDelUser() {
		UserService userService = getBeanByName("userService");
		userService.delUser(12222);
	}

	@Test
	public void testUpdateUser() {
		UserService userService = getBeanByName("userService");
		User user = new User();
		user.setId(12345699);
		user.setSclass("092");
		user.setSno("2030999");
		user.setName("Miss.base");
		user.setEmail("emaaaa@gamil.com");
		user.setAuthority("ROLE_ADMIN");
		Assert.assertTrue(userService.updateUser(user));
	}
}
