package dao;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.info.dao.BalanceRecordDao;
import com.info.dao.UserDao;
import com.info.pojo.BalanceRecord;

/** 
 * @author  Viking
 * @version 创建时间：2012-8-18 下午03:35:08 
 * 
 */
public class BalanceRecordTest extends BaseTest{
	@Test
	public void insertRecord(){
		BalanceRecord record = new BalanceRecord();
		record.setUid(3);
		record.setBalance(2);
		record.setOtype(0);
		record.setOtime(new Timestamp(System.currentTimeMillis()));
		BalanceRecordDao bDao = (BalanceRecordDao) classPathXmlApplicationContext.getBean("balanceRecordDao");
		bDao.insertRecord(record, 3);
	}
	@Test
	public void queryRecordList(){
		List list = sqlMapClientTemplate.queryForList("record.queryRecordList", 3, 0, 2);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	@Test
	public void getRecordCount(){
		Map map = new HashMap();
		map.put("uid",3);
		int count = (Integer) sqlMapClientTemplate.queryForObject("record.getRecordCount", map);
		System.out.println(count);
	}

}
