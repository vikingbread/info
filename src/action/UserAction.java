package com.info.action;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.info.pojo.IDInfo;
import com.info.pojo.LoginRecord;
import com.info.pojo.User;
import com.info.service.LoginRecordService;
import com.info.service.UserService;
import com.info.utils.IDCache;
import com.info.utils.MD5Util;
import com.info.utils.PageUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/** 
 * @author  Viking
 * @version 创建时间：2012-8-17 下午05:41:52 
 * 所有用户操作action
 */
@Controller("userAction")
@Scope("prototype")
public class UserAction extends ActionSupport {
	private User user;
	private UserService userService;
	private LoginRecordService loginRecordService;
	private List<User> list;
	private PageUtil page = new PageUtil();
	private boolean success;
	private long idNumber;
	private String errorMsg;
	private String newPasswd;
	
	public String login(){
		User u = userService.login(user.getName(), user.getPasswd());
		if(u==null){
			return LOGIN;
		}
		Timestamp currentTime = new Timestamp(System.currentTimeMillis());
		
		String thisIp = ServletActionContext.getRequest().getRemoteHost();
		LoginRecord loginRecord = new LoginRecord();
		loginRecord.setIp(thisIp);
		loginRecord.getUser().setId(u.getId());
		loginRecord.setLoginTime(currentTime);
		loginRecordService.addLoginRecord(loginRecord);//保存登陆记录
		
		user.setId(u.getId());
		user.setRecentlyLoginIp(thisIp);		
		user.setRecentlyLoginTime(currentTime);
		userService.updateLoginInfo(user);
		user.setPasswd(MD5Util.getMD5(user.getPasswd()));//加密密码 防止在跳转时泄露
		Map<String, Object> session = ActionContext.getContext().getSession();
		u.setPasswd("");//清空密码
		session.put("user", u);
		return SUCCESS;
	}

	/**
	 *json验证用户信息是否在正确 
	 */
	public String userCheck(){
		boolean ret = userService.checkUser(user.getName(), user.getPasswd());
		if(ret){
			success = true;
		}
		return SUCCESS;
	}

	/**
	 * 页面端请求相应卡号的方法
	 * @return
	 */
	public String getId(){
		//获得主机ip
		String ip = ServletActionContext.getRequest().getRemoteHost();
		IDCache cache = IDCache.getCache();
		IDInfo idInfo = cache.getInfo(ip);
		if(idInfo==null){
			success = false;
			errorMsg = "未能获得卡号信息";
		}else{
			success = true;
			idNumber = idInfo.getIDNummber();
		}
		return SUCCESS;
	}
	
	public String queryAllUsersByPage(){
		page.setPageSize(16);
		list = userService.queryAllUsersByPage(page);
		return SUCCESS;
	}
	
	public String addUser(){
		user.setPasswd(MD5Util.getMD5(user.getPasswd()));//用md5加密
		success = userService.addUser(user);
		if(!success){
			errorMsg =  "添加失败！用户已存在";
		}
		return SUCCESS;
	}
	public String updateUser0(){//跳转&准备数据
		user = userService.queryUserById(user.getId());
		return SUCCESS;
	}
	public String updateUser(){
		success = userService.updateUser(user);
		return SUCCESS;
	}
	public String changePW0(){//跳转&准备数据
		return SUCCESS;
	}
	public String changePW(){
		success = userService.changeUserPasswd(user.getName(),user.getPasswd(),newPasswd);
		return SUCCESS;
	}
	public String queryBalance(){
		user = userService.queryUserById(user.getId());
		Map<String, Object> session = ActionContext.getContext().getSession();
		User u = (User) session.get("user");
		u.setBalance(u.getBalance());
		session.put("user", u);
		success = true;
		return SUCCESS;
	}
	/**
	 * 下位机请求处理方法
	 * @return 回送给下位机的信息
	 */
	public String queryUserInfo(){
	
		String thisIp = ServletActionContext.getRequest().getRemoteHost();
		IDInfo idInfo = new IDInfo();
		idInfo.setIDNummber(user.getId());
		idInfo.setIp(thisIp);
		idInfo.setTimeStamp(System.currentTimeMillis());
		IDCache cache = IDCache.getCache();
		cache.save(thisIp, idInfo);
	
		user = userService.queryUserById(user.getId());
		if(user == null){
			return null;//什么也不做
		}
		
		String str = userService.getUserInString(user.getId());
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf8");// 解决中文乱码
		try {
			response.getWriter().write(str);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;//null
	}

	public String queryUserById(){
		user = userService.queryUserById(user.getId());
		return SUCCESS;
	}

	public String delUser(){
		userService.delUser(user.getId());
		return SUCCESS;
	}
	public String disableUser(){
		success = userService.disableUser(user.getId());
		return SUCCESS;
	}
	public String enableUser(){
		success = userService.enableUser(user.getId());
		return SUCCESS;
	}
	
	//getter & setter  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	public UserService getUserService() {
		return userService;
	}
	@Resource
	@Required
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public boolean isSuccess() {
		return success;
	}
	public PageUtil getPage() {
		return page;
	}
	public void setPage(PageUtil page) {
		this.page = page;
	}

	public List<User> getList() {
		return list;
	}
	@Resource
	public void setLoginRecordService(LoginRecordService loginRecordService) {
		this.loginRecordService = loginRecordService;
	}

	public long getIdNumber() {
		return idNumber;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setNewPasswd(String newPasswd) {
		this.newPasswd = newPasswd;
	}

}
