package com.info.dao;

import java.util.List;
import com.info.pojo.User;
import com.info.utils.PageUtil;

/** 
 * @author  Viking
 * @version 创建时间：2012-8-17 下午08:51:18 
 * 用户dao接口
 */
public interface UserDao {
	/**
	 * 用户验证
	 * @param uname 用户名
	 * @param passwd 密码
	 * @return 匹配的用户 不存在是返回null
	 */
	User checkUser(String uname,String passwd);
	/**
	 * 更新用户登录信息
	 * @param user 需要更新的用户
	 * @return 更新影响的数目
	 */
	int updateLoginInfo(User user);
	/**
	 * 更加用户id查询其余额
	 * @param uid 用户id
	 * @return 余额
	 */
	float queryBalanceById(long uid);
	/**
	 * 更新用户余额
	 * @param balance 金额
	 * @param uid 用户id
	 */
	void updateBalance(float balance,long uid);
	/**
	 * 更加用id查询用户
	 * @param id 用户id
	 * @return 匹配的用户 不存在是返回null
	 */
	User queryUserById(long id);
	/**
	 * 根据用户名（忽略大小写）称查询用户
	 * @param name 用户名称
	 * @return 匹配的用户 不存在时返回null
	 */
	User queryUserByName(String name);
	/**
	 * 添加用户
	 * @param user 用户
	 * @return 
	 */
	boolean addUser(User user);
	/**
	 * 更具用户id删除用户
	 * @param id  用户id
	 * @return 删除成功返回 true 失败返回false
	 */
	boolean delUser(long id);
	/**
	 * 添加用户的权限
	 * @param user 用户
	 */
	void addAuthorities(User user);
	/**
	 *分页查询所有用户
	 * @param page 分页工具
	 * @return 用户列表
	 */
	List<User> queryAllUsersByPage(PageUtil page);
	/**
	 * 查询用户数量
	 * @return 用户数
	 */
	int queryUserCount();
	/**
	 * 停用用户
	 * @param id 用户Id
	 */
	void disableUser(long id);
	/**
	 * 启用账户
	 * @param id 用户Id
	 */
	void enableUser(long id);
	/**
	 * 更新用户
	 * @param user 需要更新的用户
	 * @return 更新影响的数目 
	 */
	int updateUser(User user);
	/**
	 * 更新用户密码
	 * @param uname 被更新用户
	 * @param newPasswd 新密码
	 * @return 成功返回true  否则返回false
	 */
	boolean changePasswd(String uname, String newPasswd);
}
