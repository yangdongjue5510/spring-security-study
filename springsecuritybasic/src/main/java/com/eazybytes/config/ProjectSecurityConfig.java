package com.eazybytes.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

@Configuration
public class ProjectSecurityConfig  extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/myAccount").authenticated()
			.antMatchers("/myBalance").authenticated()
			.antMatchers("/myLoans").authenticated()
			.antMatchers("/myCards").authenticated()
			.antMatchers("/notices").permitAll()
			.antMatchers("/contact").permitAll()
			.and()
			.formLogin()
			.and()
			.httpBasic();

		//DenyAll
		//http.authorizeRequests().anyRequest().denyAll().and().formLogin().and().httpBasic();

		//permitAll
		//http.authorizeRequests().anyRequest().permitAll().and().formLogin().and().httpBasic();
	}

	// @Override
	// protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	// 	// auth.inMemoryAuthentication()
	// 	// 	.withUser("admin").password("1234").authorities("admin")
	// 	// 	.and()
	// 	// 	.withUser("user").password("5678").authorities("reader")
	// 	// 	.and()
	// 	// 	.passwordEncoder(NoOpPasswordEncoder.getInstance()); //no password Encode
	//
	// 	InMemoryUserDetailsManager userDetailsService = new InMemoryUserDetailsManager();
	// 	UserDetails user = User.withUsername("admin").password("1234").authorities("admin").build();
	// 	UserDetails user1 = User.withUsername("user").password("5678").authorities("reader").build();
	// 	userDetailsService.createUser(user);
	// 	userDetailsService.createUser(user1);
	// 	auth.userDetailsService(userDetailsService);
	// }

	//UserDetailsService의 구현체로 jdbc를 사용할 것임을 알림
	// @Bean
	// public UserDetailsService userDetailsService(DataSource datasource) {
	// 	return new JdbcUserDetailsManager(datasource);
	// }
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
}
