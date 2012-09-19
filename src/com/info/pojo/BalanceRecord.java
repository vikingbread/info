package com.info.pojo;

import java.sql.Timestamp;

/** 
 * @author  Viking
 * @version 创建时间：2012-8-18 下午01:50:04 
 * 
 */
public class BalanceRecord {
	private int id;
	private long uid;
	private Timestamp otime;
	private int otype;
	private float balance;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getUid() {
		return uid;
	}
	public void setUid(long uid) {
		this.uid = uid;
	}
	public Timestamp getOtime() {
		return otime;
	}
	public void setOtime(Timestamp otime) {
		this.otime = otime;
	}
	public int getOtype() {
		return otype;
	}
	public void setOtype(int otype) {
		this.otype = otype;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	
	@Override
	public String toString() {
		return "BalanceRecord [id=" + id + ", uid=" + uid + ", otime=" + otime
				+ ", otype=" + otype + ", balance=" + balance + "]";
	}

}
