package com.info.pojo;
/** 
 * @author  Viking
 * @version ����ʱ�䣺2012-9-19 ����08:44:39 
 * Ȩ����Ϣ��
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
