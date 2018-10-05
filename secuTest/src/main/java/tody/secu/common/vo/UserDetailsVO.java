package tody.secu.common.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserDetailsVO implements UserDetails {
	
	private String user_id;
	private String user_pw;
	private String name;
	private List<String> authorities;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// 계정이 갖고 있는 권한 목록 리턴
		ArrayList<GrantedAuthority> auth = new ArrayList<GrantedAuthority>();
		for(String role : authorities) {
			auth.add(new SimpleGrantedAuthority(role));
		}
		return auth;
	}

	@Override
	public String getPassword() {
		// 계정의 패스워드 리턴
		return user_pw;
	}

	@Override
	public String getUsername() {
		// 계정의 이름(id) 리턴
		return user_id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	// 체크할 필요가 없다면 true로 하면 됨
	@Override
	public boolean isAccountNonExpired() {
		// 계정이 만료되지 않았는 지 리턴(true:만료안됨)
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// 계정이 잠겨있지 않은 지 리턴(true:계정안잠김)
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// 패스워드가 만료되지 않은 지 리턴(true:만료안됨)
		return true;
	}

	@Override
	public boolean isEnabled() {
		// 계정 사용 가능한 지 리턴(true:사용가능)
		return true;
	}

}
