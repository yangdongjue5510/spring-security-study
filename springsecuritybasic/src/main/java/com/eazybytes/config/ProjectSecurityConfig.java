package com.eazybytes.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;

@Configuration
public class ProjectSecurityConfig  extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// http.authorizeRequests()
		// 	.antMatchers("/myAccount").authenticated()
		// 	.antMatchers("/myBalance").authenticated()
		// 	.antMatchers("/myLoans").authenticated()
		// 	.antMatchers("/myCards").authenticated()
		// 	.antMatchers("/notices").permitAll()
		// 	.antMatchers("/contact").permitAll()
		// 	.and()
		// 	.formLogin()
		// 	.and()
		// 	.httpBasic();

		//DenyAll
		//http.authorizeRequests().anyRequest().denyAll().and().formLogin().and().httpBasic();

		http.authorizeRequests().anyRequest().permitAll().and().formLogin().and().httpBasic();
	}
}
