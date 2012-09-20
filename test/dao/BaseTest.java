package dao;

import org.junit.Before;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

/** 
 * @author  Viking
 * @version 创建时间：2012-8-18 下午03:36:26 
 * 
 */
public class BaseTest {

	protected SqlMapClientTemplate sqlMapClientTemplate;
	protected ClassPathXmlApplicationContext classPathXmlApplicationContext ;
	public BaseTest() {
		super();
	}
	protected <T> T getBean(String beanName) {
		return (T) classPathXmlApplicationContext.getBean(beanName);
	}
	@Before
	public void prepare() {
		classPathXmlApplicationContext = new ClassPathXmlApplicationContext(
				"classpath:/beans.xml");
		sqlMapClientTemplate = (SqlMapClientTemplate) classPathXmlApplicationContext.getBean("sqlMapClientTemplate");
	}

}