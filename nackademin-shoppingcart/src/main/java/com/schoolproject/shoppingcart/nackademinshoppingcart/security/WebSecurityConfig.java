package com.schoolproject.shoppingcart.nackademinshoppingcart.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.schoolproject.shoppingcart.nackademinshoppingcart.siteuser.service.SiteUserService;



@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	SiteUserService siteUserService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	//Spring security configuration that handles access config.
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		//@formatter:off
		http
			.authorizeRequests()
				.antMatchers(
					"/",
					"/h2/**")
				.permitAll()
				.antMatchers(
					"/css/*",
					"/img/*",
					"/js/**")
				.permitAll()
				.antMatchers(
					HttpMethod.POST,
					"/paymentiq/**")
				.permitAll()
			.anyRequest()
				.authenticated()
			.and()
			.formLogin()
				.loginPage("/login")
				.usernameParameter("email")
				.passwordParameter("password")
				.defaultSuccessUrl("/")
				.permitAll()
			.and()
			.logout()
				.permitAll()
				.logoutSuccessUrl("/login");
		http.csrf().disable();
		http.headers().frameOptions().disable();
		//@formatter:on

	}
	
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		
		/*//@formatter:off
		auth.inMemoryAuthentication()
		.withUser("username")
		.password("password")
		.roles("USER");	
		//@formatter:on*/
	}

	//Spring Security login configuration. so it authenticates a custom user.
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		try {
			auth.userDetailsService(siteUserService).passwordEncoder(passwordEncoder);
		} catch( Exception e){
			e.printStackTrace();
		}
	}
}
