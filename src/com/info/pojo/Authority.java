package com.info.pojo;
/** 
 * @author  Viking
 * @version 创建时间：2012-9-19 上午08:44:39 
 * 权限信息类
 */
public class Authority {
	
	private String name;
	private String authority;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	@Override
	public String toString() {
		return "Authority [name=" + name + ", authority=" + authority + "]";
	}

}
