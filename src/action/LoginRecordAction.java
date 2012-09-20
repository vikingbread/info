package com.info.action;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import com.info.pojo.LoginRecord;
import com.info.service.LoginRecordService;
import com.info.utils.PageUtil;
import com.opensymphony.xwork2.ActionSupport;

/** 
 * @author  Viking
 * @version ����ʱ�䣺2012-9-13 ����05:24:41 
 * �û���½��¼Action
 * ���ṩɾ������
 */
@Component("loginRecordAction")
public class LoginRecordAction extends ActionSupport{
	private LoginRecordService loginRecordService;
	private LoginRecord loginRecord = new LoginRecord();
	private PageUtil page = new PageUtil();
	private List<LoginRecord> list;

	public String queryAllLoginRecords(){
		list = loginRecordService.queryAllLoginRecords(page, loginRecord.getUser().getId());
		return SUCCESS;
	}
	
	
	//setter & getter ~~~~~~~~~~~~~~~~~~
	public PageUtil getPage() {
		return page;
	}

	public LoginRecord getLoginRecord() {
		return loginRecord;
	}
	@Resource
	public void setLoginRecordService(LoginRecordService loginRecordService) {
		this.loginRecordService = loginRecordService;
	}

	public List<LoginRecord> getList() {
		return list;
	}

	public void setLoginRecord(LoginRecord loginRecord) {
		this.loginRecord = loginRecord;
	}

	public void setPage(PageUtil page) {
		this.page = page;
	}
	
}
