package com.info.mysecurityimpl;

import java.util.Arrays;
import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

/**
 * @author Viking
 * @version 创建时间：2012-9-19 上午08:51:29
 * 
 */
public class Account extends User {
	private final long uid;

	// private final String hash;

	public Account(long uid, String username, String password, boolean enabled,
			boolean accountNonExpired, boolean credentialsNonExpired,
			boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired,
				credentialsNonExpired, accountNonLocked, authorities);
		this.uid = uid;
	}

	public Account(int uid, String username, String password, boolean enabled,
			boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked,
			GrantedAuthority[] authorities) {

		super(username, password, enabled, accountNonExpired,
				credentialsNonExpired,

				accountNonLocked, authorities == null ? null : Arrays
						.asList(authorities));

		this.uid = uid;
	}

	public long getUid() {
		return uid;
	}
}
