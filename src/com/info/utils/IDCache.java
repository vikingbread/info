package com.info.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.info.pojo.IDInfo;
import com.sun.jmx.snmp.Timestamp;

/**
 * @author Viking
 * @version 创建时间：2012-9-15 下午06:29:31  <p>记录下位机提交的卡号 定时删除过期记录
 */
public class IDCache implements Runnable {
	private static Log logger = LogFactory.getLog(IDCache.class);
	private static final int TIME_OUT = 5 * 60 * 1000;// 单位为毫秒
	private final Map<String, IDInfo> cache = new HashMap<String, IDInfo>();
	private final static IDCache ID_RE_CACHE = new IDCache();
	static {//测试用
		IDInfo idInfo = new IDInfo();
		idInfo.setIDNummber(12345678);
		idInfo.setIp("127.0.0.1");
		idInfo.setTimeStamp(System.currentTimeMillis());
		ID_RE_CACHE.save("127.0.0.1", idInfo);
	}

	public static IDCache getCache(){
		return ID_RE_CACHE;
	}
	
	public void save(String ip, IDInfo idInfo) {
		synchronized (cache) {
			cache.put(ip, idInfo);
		}
		logger.info("有新的卡号被提交。来至主机:"+ip);
	}

	public IDInfo getInfo(String ip) {
		return cache.get(ip);
	}

	private IDCache() {
		new Thread(this).start();
	}

	@Override
	public void run() {
		long current = 0L;
		Iterator<Entry<String, IDInfo>> iterator;
		IDInfo idInfo;
		while (true) {
			System.out.println("处理线程");
			current = System.currentTimeMillis();
			synchronized (cache) {
				iterator = cache.entrySet().iterator();
				while (iterator.hasNext()) {
					idInfo = iterator.next().getValue();
					if (idInfo.getTimeStamp() + TIME_OUT < current) {
						iterator.remove();
					}
				}
			}
			try {
				Thread.sleep(TIME_OUT);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public String toString() {
		return "IDCache [cache=" + cache + "]";
	}
}
