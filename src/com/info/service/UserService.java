package com.info.service;

import java.util.List;

import com.info.pojo.User;
import com.info.utils.PageUtil;

/** 
 * @author  Viking
 * @version ����ʱ�䣺2012-9-6 ����02:08:17 
 * 
 */
public interface UserService {
	/**
	 * ����û��Ƿ�ƥ��
	 * @param uname �û�����
	 * @param upasswd ����
	 * @return ƥ�䣺true ���򷵻�false
	 */
	boolean checkUser(String uname,String upasswd);
	/**
	 * �û���¼
	 * @param uname �û�����
	 * @param upasswd �û�����
	 * @return  ƥ����û�
	 */
	User login(String uname,String upasswd);
	/**
	 * �����û���¼��¼
	 * @param user ��Ҫ���µ��û�
	 */
	void updateLoginInfo(User user);
	/**
	 * ͨ���û�Id��ѯ�û�
	 * @param id ��Ҫ��ѯ���û�id
	 * @return ƥ����û� ��������ʱ����null
	 */
	User queryUserById(long id);
	/**
	 * 
	 * @param id : userId
	 * @return �����û�Э��ת�����ַ���
	 */
	String getUserInString(long id);
	/**
	 * ����û�
	 */
	boolean addUser(User user);
	/**
	 * ɾ���û�
	 */
	boolean delUser(long userId);
	/**
	 * ��ҳ��ѯ�û�
	 */
	List<User> queryAllUsersByPage(PageUtil page);
	/**
	 * ͣ���û�
	 * @param id ��Ҫͣ���û���Id
	 */
	boolean disableUser(long id);
	/**
	 * �����û�
	 * @param id ��Ҫ�����û���Id
	 */
	boolean enableUser(long id);
	/**
	 * �����û���Ϣ
	 * @param user ��Ҫ���µ��û�
	 */
	boolean updateUser(User user);
	/**
	 * �����û�����
	 * @param uname �û���
	 * @param passwd ������
	 * @param newPasswd ������
	 * @return �ɹ�����true ���򷵻�false
	 */
	boolean changeUserPasswd(String uname,String passwd,String newPasswd);
}
