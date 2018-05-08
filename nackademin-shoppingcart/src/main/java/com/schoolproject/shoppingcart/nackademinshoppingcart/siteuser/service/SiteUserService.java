package com.schoolproject.shoppingcart.nackademinshoppingcart.siteuser.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.schoolproject.shoppingcart.nackademinshoppingcart.siteuser.SiteUser;
import com.schoolproject.shoppingcart.nackademinshoppingcart.siteuser.dao.SiteUserDao;

@Service
public class SiteUserService implements UserDetailsService {
	
	@Autowired
	SiteUserDao siteUserDao;
	
	public void saveSiteUser(SiteUser siteUser) {
		siteUserDao.save(siteUser);
	}
	
	public SiteUser findByUserId(Long userId) {
		SiteUser user = siteUserDao.findByUserId(userId);
		
		return user;
	}
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		SiteUser user = siteUserDao.findByEmail(email);

		if (user == null) {

			throw new UsernameNotFoundException(email);

		}

		List<GrantedAuthority> auth = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");

		String password = user.getPassword();

		return new User(email, password, auth);

	}
}

