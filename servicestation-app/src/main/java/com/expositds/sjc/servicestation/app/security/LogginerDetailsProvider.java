package com.expositds.sjc.servicestation.app.security;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.expositds.sjc.servicestation.domain.model.Logginer;
import com.expositds.sjc.servicestation.domain.service.Identification;

/**
 * 
 * @author Alexey Suslov
 *
 */
@Service("userDetailsService")
public class LogginerDetailsProvider implements UserDetailsService, Serializable{
	
	
	private static final long serialVersionUID = 6914090858516617146L;
	
	@Autowired
	private Identification identification;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		final Logginer logginer = identification.getLogginerByName(username);
		
		return new UserDetails() {

			private static final long serialVersionUID = -7620814109666482992L;

			@Override
			public Collection<? extends GrantedAuthority> getAuthorities() {
				List<GrantedAuthority> auth = new ArrayList<>();
				auth.add(new SimpleGrantedAuthority("ROLE_" + logginer.getRole().toString()));
				return auth;
			}

			@Override
			public String getPassword() {
				return logginer.getPassword();
			}

			@Override
			public String getUsername() {
				return logginer.getLogin();
			}

			@Override
			public boolean isAccountNonExpired() {
				return true;
			}

			@Override
			public boolean isAccountNonLocked() {
				return true;
			}

			@Override
			public boolean isCredentialsNonExpired() {
				return true;
			}

			@Override
			public boolean isEnabled() {
				return true;
			}
			
		};
	}

}
