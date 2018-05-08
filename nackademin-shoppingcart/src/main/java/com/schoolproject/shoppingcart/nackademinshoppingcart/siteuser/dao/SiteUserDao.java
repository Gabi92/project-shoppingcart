package com.schoolproject.shoppingcart.nackademinshoppingcart.siteuser.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.schoolproject.shoppingcart.nackademinshoppingcart.siteuser.SiteUser;

@Repository
public interface SiteUserDao extends CrudRepository<SiteUser, Long>{
	
	SiteUser findByUserId(Long userId);

	
}
