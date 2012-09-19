package com.info.interceptor;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 
 * @author Viking
 * δ��½��������س�����½��֮������
 * ��Action�����󲢼�¼������Ϣ���Ա��ڵ�
 * ½�������ת�������������Ӧҳ��
 * 
 * ʹ��Spring Security���档�Ѳ�ʹ�ã�
 *
 */
@Deprecated
public class AuthInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {

		HttpServletRequest request = ServletActionContext.getRequest();
		String s = request.getRequestURI();
		Map session = ActionContext.getContext().getSession();
		if(s.endsWith("userCheck")||s.endsWith("login")||s.endsWith("saveRecord")||s.endsWith("queryUserInfo")){
			return arg0.invoke();
		}
		//session.get
		if (session.get("user") == null) {//����û�Ϊ�� ,��ô��Ҫ���浱ǰ�������ַ
			String paramString = getRequestParams(request);
			session.put("requestURL", s+paramString);
			return Action.LOGIN;
		}
		return arg0.invoke();
	}
	/**
	 * �������Ĳ���
	 * @param request
	 * @return ����Ĳ����ַ���
	 */
	private String getRequestParams(HttpServletRequest request) {
		Enumeration names = request.getParameterNames();
		Map<String, String> paramsAndValues = new HashMap<String, String>();
		StringBuilder params = new StringBuilder("?");
		while(names.hasMoreElements()){
			String name = names.nextElement().toString();
			params.append(name + "=" ) .append( request.getAttribute(name)).append("&");
		}
		String paramString = "";
		if(params.length()>1){
			paramString = params.substring(0, params.length()-1);
		}
		return paramString;
	}

}