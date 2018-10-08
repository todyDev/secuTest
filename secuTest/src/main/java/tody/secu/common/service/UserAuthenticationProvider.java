package tody.secu.common.service;

import java.util.Collection;
import java.util.Collections;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import tody.secu.common.vo.UserDetailsVO;

public class UserAuthenticationProvider implements AuthenticationProvider {

	Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	private UserDetailService userDeSer;
	
	@SuppressWarnings("unchecked")
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		// TODO Auto-generated method stub
		
		String username = authentication.getName();
		String password = (String) authentication.getCredentials();
		
		log.debug("authenticationProvider::::: "+ username +" / "+ password);
		
		UserDetailsVO user = null;
		Collection<GrantedAuthority> authorities = null;
		
		user = (UserDetailsVO)userDeSer.loadUserByUsername(username);
		log.debug("authenticationProvider::::: DB :: "+user.getUsername()+" / "+user.getPassword());
		
		authorities = (Collection<GrantedAuthority>) user.getAuthorities();
		
		return new UsernamePasswordAuthenticationToken(username, password, authorities);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return true;
	}

}
