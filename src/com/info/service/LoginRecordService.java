package com.info.service;

import java.util.List;

import com.info.pojo.LoginRecord;
import com.info.utils.PageUtil;

/**
 * @author Viking
 * @version ����ʱ�䣺2012-9-15 ����09:19:55
 * 
 */
public interface LoginRecordService {

	/**
	 * ��ҳ��ѯ�����û���½��¼
	 * 
	 * @param page
	 *            ��ҳ����
	 * @param uid
	 *            ��Ҫ��ѯ�û���id ��id<=0��ʾ��ѯ�����û�
	 * @return ��½�б�
	 */
	List<LoginRecord> queryAllLoginRecords(PageUtil page, long uid);
	/**
	 * ����һ����½��¼
	 * @param loginRecord ��½��¼ 
	 * @return �ɹ�����true ʧ�ܷ���false
	 */
	boolean addLoginRecord(LoginRecord loginRecord);
}
