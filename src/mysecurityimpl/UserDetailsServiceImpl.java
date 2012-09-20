package com.info.mysecurityimpl;

import java.util.Collection;
import java.util.HashSet;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import com.info.pojo.Authority;

/**
 * @author Viking
 * @version 创建时间：2012-9-18 下午09:01:10
 * 
 */
public class UserDetailsServiceImpl implements UserDetailsService {

	private SqlMapClientTemplate sqlMapClientTemplate;
	private static Log logger = LogFactory.getLog(UserDetailsServiceImpl.class);
	private StringBuilder sb;
	HttpServletRequest request ;

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
	

		// 根据用户名获取帐户和权限信息
//		Authority authority = (Authority) sqlMapClientTemplate.queryForObject(
//				"authoritiesByUsernameQuery", username);
		com.info.pojo.User user = (com.info.pojo.User) sqlMapClientTemplate.queryForObject("usersByUsernameQuery", username);
		
		if (user == null) {
			if(sb.length()!=0){
				sb.delete(0, sb.length());
			}
			
			request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();  
			//在用户不存在  肯定是绕过了登陆界面 。 直接登陆所致。予以记录
			sb.append("用户为").append(username).append("的用户非法登陆失败.").append("其ip为").append(request.getRemoteAddr());
		
			logger.warn(sb.toString());
			throw new UsernameNotFoundException("用户不存在！");
		}
		Collection<GrantedAuthority> grantedAuths = new HashSet<GrantedAuthority>(1);
		grantedAuths.add(new SimpleGrantedAuthority(user.getAuthorities().getAuthority()));

		boolean enabled = user.isEnabled();  
		return new Account(user.getId(),username, user.getPasswd(), enabled, true, true, true,
				grantedAuths);
	}
	
	
	// getter & setter ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public void setSqlMapClientTemplate(
			SqlMapClientTemplate sqlMapClientTemplate) {
		this.sqlMapClientTemplate = sqlMapClientTemplate;
	}

}
