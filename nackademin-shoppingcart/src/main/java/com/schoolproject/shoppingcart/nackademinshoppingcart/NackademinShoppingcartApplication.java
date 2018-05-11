package com.schoolproject.shoppingcart.nackademinshoppingcart;

import com.schoolproject.shoppingcart.nackademinshoppingcart.siteuser.SiteUser;
import com.schoolproject.shoppingcart.nackademinshoppingcart.siteuser.service.SiteUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class NackademinShoppingcartApplication {

	@Autowired
	SiteUserService siteUserService;

	public static void main(String[] args) {
		SpringApplication.run(NackademinShoppingcartApplication.class, args);
	}

	
	
	
	// Creates and saves initial users to the database at startup.
	@Bean
	CommandLineRunner runner() {

		return args -> {
			siteUserService.saveSiteUser(new SiteUser("TestSEK",
					"testsson",
					"testvgn123",
					"testcity",
					"75757",
					"Sweden",
					"Test1@gmail.com",
					"password",
					"1990-01-01",
					"0760000000"));


			siteUserService.saveSiteUser(new SiteUser("TestEUR",
					"testsson2",
					"testvgn123",
					"testcity2",
					"75756",
					"Spain",
					"Test2@gmail.com",
					"password",
					"1990-01-02",
					"0760000002"));
		};
	}
	
	
	// Password encoder for encryption of user password.
	@Bean
	PasswordEncoder getEncoder() {
		
		return new BCryptPasswordEncoder();
	}
}
