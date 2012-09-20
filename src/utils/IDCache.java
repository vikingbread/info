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
 * @version ����ʱ�䣺2012-9-15 ����06:29:31  <p>��¼��λ���ύ�Ŀ��� ��ʱɾ�����ڼ�¼
 */
public class IDCache implements Runnable {
	private static Log logger = LogFactory.getLog(IDCache.class);
	private static final int TIME_OUT = 5 * 60 * 1000;// ��λΪ����
	private final Map<String, IDInfo> cache = new HashMap<String, IDInfo>();
	private final static IDCache ID_RE_CACHE = new IDCache();
	static {//������
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
		logger.info("���µĿ��ű��ύ����������:"+ip);
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
			System.out.println("�����߳�");
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