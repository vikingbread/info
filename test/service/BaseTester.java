package service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.interceptor.annotations.Before;

/**
 * @author Viking
 * @version ����ʱ�䣺2012-9-13 ����05:36:13
 * 
 */
public class BaseTester {
	ApplicationContext context = new ClassPathXmlApplicationContext(
			"classpath:/beans.xml");;

	protected <T> T getBeanByName(String beanName) {
		return (T) context.getBean(beanName);
	}

}
