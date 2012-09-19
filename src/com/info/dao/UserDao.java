package com.info.dao;

import java.util.List;
import com.info.pojo.User;
import com.info.utils.PageUtil;

/** 
 * @author  Viking
 * @version ����ʱ�䣺2012-8-17 ����08:51:18 
 * �û�dao�ӿ�
 */
public interface UserDao {
	/**
	 * �û���֤
	 * @param uname �û���
	 * @param passwd ����
	 * @return ƥ����û� �������Ƿ���null
	 */
	User checkUser(String uname,String passwd);
	/**
	 * �����û���¼��Ϣ
	 * @param user ��Ҫ���µ��û�
	 * @return ����Ӱ�����Ŀ
	 */
	int updateLoginInfo(User user);
	/**
	 * �����û�id��ѯ�����
	 * @param uid �û�id
	 * @return ���
	 */
	float queryBalanceById(long uid);
	/**
	 * �����û����
	 * @param balance ���
	 * @param uid �û�id
	 */
	void updateBalance(float balance,long uid);
	/**
	 * ������id��ѯ�û�
	 * @param id �û�id
	 * @return ƥ����û� �������Ƿ���null
	 */
	User queryUserById(long id);
	/**
	 * �����û��������Դ�Сд���Ʋ�ѯ�û�
	 * @param name �û�����
	 * @return ƥ����û� ������ʱ����null
	 */
	User queryUserByName(String name);
	/**
	 * ����û�
	 * @param user �û�
	 * @return 
	 */
	boolean addUser(User user);
	/**
	 * �����û�idɾ���û�
	 * @param id  �û�id
	 * @return ɾ���ɹ����� true ʧ�ܷ���false
	 */
	boolean delUser(long id);
	/**
	 * ����û���Ȩ��
	 * @param user �û�
	 */
	void addAuthorities(User user);
	/**
	 *��ҳ��ѯ�����û�
	 * @param page ��ҳ����
	 * @return �û��б�
	 */
	List<User> queryAllUsersByPage(PageUtil page);
	/**
	 * ��ѯ�û�����
	 * @return �û���
	 */
	int queryUserCount();
	/**
	 * ͣ���û�
	 * @param id �û�Id
	 */
	void disableUser(long id);
	/**
	 * �����˻�
	 * @param id �û�Id
	 */
	void enableUser(long id);
	/**
	 * �����û�
	 * @param user ��Ҫ���µ��û�
	 * @return ����Ӱ�����Ŀ 
	 */
	int updateUser(User user);
	/**
	 * �����û�����
	 * @param uname �������û�
	 * @param newPasswd ������
	 * @return �ɹ�����true  ���򷵻�false
	 */
	boolean changePasswd(String uname, String newPasswd);
}
