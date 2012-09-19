package service;

import java.util.List;
import junit.framework.Assert;
import org.junit.Test;
import com.info.pojo.LoginRecord;
import com.info.pojo.User;
import com.info.service.LoginRecordService;
import com.info.utils.PageUtil;

/** 
 * @author  Viking
 * @version 创建时间：2012-9-15 上午10:48:44 
 * 
 */
public class LoginRecordServiceTest extends BaseTester{
	@Test
	public void testAddLoginRecord(){
		LoginRecord loginRecord = new LoginRecord();
		loginRecord.setUser(new User());
		loginRecord.getUser().setId(2682685451L);
		loginRecord.setIp("123.1.0.12");
	//	loginRecord.setLoginTime(new Timestamp(System.currentTimeMillis()));
		LoginRecordService loginRecordService = getBeanByName("loginRecordService");
		Assert.assertTrue(loginRecordService.addLoginRecord(loginRecord));
	}
	
	@Test 
	public void testQueryLoginRecord(){
		LoginRecordService loginRecordService = getBeanByName("loginRecordService");
		PageUtil page = new PageUtil();
	//	List<LoginRecord> list = loginRecordService.queryAllLoginRecords(page, 2682685451L);
		List<LoginRecord> list = loginRecordService.queryAllLoginRecords(page, -1);//查所有
	//	List<LoginRecord> list = loginRecordService.queryAllLoginRecords(page, 9999);//查不存在
		System.out.println(list);
	}
	
}
