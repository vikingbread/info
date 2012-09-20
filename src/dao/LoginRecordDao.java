package com.info.dao;

import java.util.List;
import java.util.Map;
import com.info.pojo.LoginRecord;
import com.info.utils.PageUtil;

/** 
 * @author  Viking
 * @version ����ʱ�䣺2012-9-15 ����09:51:32 
 * �û���½��Ϣ�־û���
 * ���ṩɾ������
 */
public interface LoginRecordDao {
	/**
	 * �����û�id��ҳ��ѯ�û���½��¼
	 * @param page ��ҳ����
	 * @param map map ��Ӧĳ���û�id��key-value ��ѯ����ʱΪ��
	 * @return ��½��Ϣ�б�
	 */
	List<LoginRecord> queryAllLoginRecords(PageUtil page,Map<String, String> map);
	
	/**
	 * ����û���½��¼
	 * @param loginRecord ��½��¼
	 */
	void addLoginRecord(LoginRecord loginRecord);
	/**
	 * ��ѯ�û���½��¼
	 * @param map ��Ӧĳ���û�id��key-value ��ѯ����ʱΪ��
	 * @return
	 */
	public int getLoginRecordCount(Map<String, String> map);
}
