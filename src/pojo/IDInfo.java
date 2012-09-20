package com.info.pojo;
/** 
 * @author  Viking
 * @version 创建时间：2012-9-15 下午07:45:58 
 * 下位机卡号缓存类
 */
public class IDInfo {
	/**
	 * ip地址
	 */
	private String ip;
	/**
	 * 卡号
	 */
	private long IDNummber;
	/**
	 * 时间戳
	 */
	private long timeStamp;
	
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public long getIDNummber() {
		return IDNummber;
	}
	public void setIDNummber(long iDNummber) {
		IDNummber = iDNummber;
	}
	public long getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}
	@Override
	public String toString() {
		return "IDInfo [ip=" + ip + ", IDNummber=" + IDNummber + ", timeStamp="
				+ timeStamp + "]";
	}
}
