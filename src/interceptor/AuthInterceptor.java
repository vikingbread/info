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
 * 未登陆的情况拦截除‘登陆’之外所有
 * 对Action的请求并记录请求信息，以便在登
 * 陆后可以跳转到到该请求的相应页面
 * 
 * 使用Spring Security代替。已不使用！
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
		if (session.get("user") == null) {//如果用户为空 ,那么就要保存当前的请求地址
			String paramString = getRequestParams(request);
			session.put("requestURL", s+paramString);
			return Action.LOGIN;
		}
		return arg0.invoke();
	}
	/**
	 * 获得请求的参数
	 * @param request
	 * @return 请求的参数字符串
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