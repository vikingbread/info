package com.info.pojo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class User implements Serializable{
	
	private long id;
	private String name;
	private String sex;
	private String passwd;
	private String sclass;
	private String sno;
	private String email;
	private Timestamp createtime;
	private Timestamp recentlyLoginTime;
	private String recentlyLoginIp;
	private float balance;
	private boolean enabled;
	/**
	 * 这里两个权限  双轨制哈~ 目前我还没有好的办法 parameterMap不会配啊
	 */
	private String authority;
	private Authority authorities;
	

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getSclass() {
		return sclass;
	}
	public void setSclass(String sclass) {
		this.sclass = sclass;
	}
	
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Timestamp getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	
	public Timestamp getRecentlyLoginTime() {
		return recentlyLoginTime;
	}
	public void setRecentlyLoginTime(Timestamp recentlyLoginTime) {
		this.recentlyLoginTime = recentlyLoginTime;
	}
	public String getRecentlyLoginIp() {
		return recentlyLoginIp;
	}
	public void setRecentlyLoginIp(String recentlyLoginIp) {
		this.recentlyLoginIp = recentlyLoginIp;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		if(!sex.equals("女")&&!sex.equals("男")){
			throw new IllegalArgumentException("性别不能为:"+sex);
		}
		this.sex = sex;
	}
	
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	public Authority getAuthorities() {
		return authorities;
	}
	public void setAuthorities(Authority authorities) {
		this.authorities = authorities;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", sex=" + sex
				+ ", passwd=" + passwd + ", sclass=" + sclass + ", sno=" + sno
				+ ", email=" + email + ", createtime=" + createtime
				+ ", recentlyLoginTime=" + recentlyLoginTime
				+ ", recentlyLoginIp=" + recentlyLoginIp + ", balance="
				+ balance + ", enabled=" + enabled + ", authority=" + authority
				+ ", authorities=" + authorities + "]";
	}

}
