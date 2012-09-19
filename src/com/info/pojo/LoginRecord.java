package com.info.pojo;

import java.sql.Timestamp;

/** 
 * @author  Viking
 * @version 创建时间：2012-9-15 上午09:11:46 
 * 
 */
public class LoginRecord {
	
	private long id;
	private User user = new User();
	private String ip;
	private Timestamp loginTime;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Timestamp getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(Timestamp loginTime) {
		this.loginTime = loginTime;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "LoginRecord [id=" + id + ", user=" + user + ", ip=" + ip + ", loginTime=" + loginTime + "]";
	}
	
}
