package com.info.action;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;
import javax.annotation.Resource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import com.info.pojo.BalanceRecord;
import com.info.pojo.User;
import com.info.service.BalanceRecordService;
import com.info.utils.PageUtil;
import com.opensymphony.xwork2.ActionSupport;

/** 
 * @author  Viking
 * @version ����ʱ�䣺2012-8-18 ����09:50:02 
 * ������action��
 */
@Controller("balanceRecordAction")
public class BalanceRecordAction extends ActionSupport {
	private static Log logger = LogFactory.getLog(BalanceRecordAction.class);
	private PageUtil page = new PageUtil();
	private List<BalanceRecord> list;
	private BalanceRecordService balanceRecordService;
	private boolean success;
	private BalanceRecord record;
	private User user ;
	
	public String queryAllRecordsByPage() {
		page.setPageSize(12);
		list = balanceRecordService.queryRecordsPageById(page, user.getId()); 
		return SUCCESS;
	}
    /**
     * ��λ�����ѣ���Ǯ������
     * @return ����null
     * @throws IOException
     */
	public String saveRecord() throws IOException {
		System.out.println(this.getClass().getName()+"saveRecord : balance = " + record.getBalance());
		System.out.println(this.getClass().getName()+"saveRecord : id = " + user.getId());
		record.setOtime(new Timestamp(System.currentTimeMillis()));
		record.setUid(user.getId());
		success = balanceRecordService.insertRecord(record, user.getId());
		logger.info("����Ϊ"+user.getId()+"���û����"+record.getBalance()+"Ԫ");
		return null;// ���ﷵ��null
	}
	
	
    //getter & setter ~~~~~~~~~~~~~~~~~~~~
	public PageUtil getPage() {
		return page;
	}

	public void setPage(PageUtil page) {
		this.page = page;
	}

	public List<BalanceRecord> getList() {
		return list;
	}

	public void setList(List<BalanceRecord> list) {
		this.list = list;
	}

	public BalanceRecordService getBalanceRecordService() {
		return balanceRecordService;
	}
	@Resource
	public void setBalanceRecordService(BalanceRecordService balanceRecordService) {
		this.balanceRecordService = balanceRecordService;
	}

	public boolean isSuccess() {
		return success;
	}

	public BalanceRecord getRecord() {
		return record;
	}

	public void setRecord(BalanceRecord record) {
		this.record = record;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
