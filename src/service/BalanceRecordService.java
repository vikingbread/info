package com.info.service;

import java.util.List;

import com.info.pojo.BalanceRecord;
import com.info.utils.PageUtil;

/** 
 * @author  Viking
 * @version ����ʱ�䣺2012-9-6 ����02:37:25 
 * 
 */
public interface BalanceRecordService {
	/**
	 * ����µ����Ѽ�¼
	 * @param record ��¼
	 * @param uid �û�id
	 * @return 
	 */
	boolean insertRecord(BalanceRecord record, long uid);
	/**
	 * �����û�id��ҳ��ѯ��¼
	 * @param page ��ҳ����
	 * @param id �û�id
	 * @return �û��б�
	 */
	List<BalanceRecord>  queryRecordsPageById(PageUtil page, long id);  
}
