package com.info.pojo;
/** 
 * @author  Viking
 * @version ����ʱ�䣺2012-9-15 ����07:45:58 
 * ��λ�����Ż�����
 */
public class IDInfo {
	/**
	 * ip��ַ
	 */
	private String ip;
	/**
	 * ����
	 */
	private long IDNummber;
	/**
	 * ʱ���
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
