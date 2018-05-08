package com.schoolproject.shoppingcart.nackademinshoppingcart.siteuser.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoolproject.shoppingcart.nackademinshoppingcart.siteuser.SiteUser;
import com.schoolproject.shoppingcart.nackademinshoppingcart.siteuser.dao.SiteUserDao;

@Service
public class SiteUserService {
	
	@Autowired
	SiteUserDao siteUserDao;
	
	public void saveSiteUser(SiteUser siteUser) {
		siteUserDao.save(siteUser);
	}
	
	public SiteUser findByUserId(Long userId) {
		SiteUser user = siteUserDao.findByUserId(userId);
		
		return user;
	}

}
