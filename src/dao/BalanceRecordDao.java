package com.info.dao;

import java.util.List;
import java.util.Map;
import com.info.pojo.BalanceRecord;
import com.info.utils.PageUtil;

/** 
 * @author  Viking
 * @version ����ʱ�䣺2012-8-18 ����09:52:25 
 * �˻���¼�ӿ�
 */
public interface BalanceRecordDao {
	/**
	 * �����û�Id��ҳ��ѯ�˻����Ѽ�¼
	 * @param page ��ҳ����
	 * @param uid �û�id
	 * @return �û���¼�б�
	 */
	List<BalanceRecord> queryAllRecordPageById(PageUtil page,long uid);
	/**
	 * ���һ���¼
	 * @param record ��Ҫ��ӵļ�¼
	 * @param uid    �û�id
	 */
	void insertRecord(BalanceRecord record,long uid);
	/**
	 * ��ѯ�û�������
	 * @param parms ��װ�õĲ�ѯ����
	 * @return ��¼����
	 */
	int queryRecordCount(Map parms);
}
