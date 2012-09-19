package com.info.service;

import java.util.List;

import com.info.pojo.User;
import com.info.utils.PageUtil;

/** 
 * @author  Viking
 * @version 创建时间：2012-9-6 下午02:08:17 
 * 
 */
public interface UserService {
	/**
	 * 检查用户是否匹配
	 * @param uname 用户名称
	 * @param upasswd 密码
	 * @return 匹配：true 否则返回false
	 */
	boolean checkUser(String uname,String upasswd);
	/**
	 * 用户登录
	 * @param uname 用户名称
	 * @param upasswd 用户密码
	 * @return  匹配的用户
	 */
	User login(String uname,String upasswd);
	/**
	 * 更新用户登录记录
	 * @param user 需要更新的用户
	 */
	void updateLoginInfo(User user);
	/**
	 * 通过用户Id查询用户
	 * @param id 需要查询的用户id
	 * @return 匹配的用户 不存在配时返回null
	 */
	User queryUserById(long id);
	/**
	 * 
	 * @param id : userId
	 * @return 根据用户协议转换的字符串
	 */
	String getUserInString(long id);
	/**
	 * 添加用户
	 */
	boolean addUser(User user);
	/**
	 * 删除用户
	 */
	boolean delUser(long userId);
	/**
	 * 分页查询用户
	 */
	List<User> queryAllUsersByPage(PageUtil page);
	/**
	 * 停用用户
	 * @param id 需要停用用户的Id
	 */
	boolean disableUser(long id);
	/**
	 * 起用用户
	 * @param id 需要起用用户的Id
	 */
	boolean enableUser(long id);
	/**
	 * 更新用户信息
	 * @param user 需要更新的用户
	 */
	boolean updateUser(User user);
	/**
	 * 更新用户密码
	 * @param uname 用户名
	 * @param passwd 旧密码
	 * @param newPasswd 新密码
	 * @return 成功返回true 否则返回false
	 */
	boolean changeUserPasswd(String uname,String passwd,String newPasswd);
}
