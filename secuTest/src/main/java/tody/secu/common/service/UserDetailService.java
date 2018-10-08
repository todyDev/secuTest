package tody.secu.common.service;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import tody.secu.common.dao.UserAuthDAO;
import tody.secu.common.vo.UserDetailsVO;

@Service
public class UserDetailService implements UserDetailsService {

	Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	private UserAuthDAO userAuthDAO;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		log.debug("loadUserByUsername::::::::::"+username);
		UserDetailsVO user = userAuthDAO.getUserById(username);
		if(user==null) {
			throw new UsernameNotFoundException("User Not Found");
		}
		return user;
	}

}
