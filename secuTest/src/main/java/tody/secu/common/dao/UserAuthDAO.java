package tody.secu.common.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import tody.secu.common.vo.UserDetailsVO;

@Repository("userAuthDAO")
public class UserAuthDAO {
	
 	@Autowired
    private SqlSessionTemplate sqlSession;

	public UserDetailsVO getUserById(String username) throws UsernameNotFoundException{
		// TODO Auto-generated method stub
		return (UserDetailsVO) sqlSession.selectOne("user.selectUserById",username);
	}

}
