package com.fet.expressnote.framework.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

//@Configuration
//@EnableWebSecurity
public class SecSecurityConfig {//extends WebSecurityConfigurerAdapter {

//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests().antMatchers("/User/**").hasRole("USER").anyRequest().authenticated();
//		 http.headers().frameOptions().disable().and().authorizeRequests().anyRequest().permitAll();
//	}

//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder authManagerBuilder) throws Exception {
//		authManagerBuilder.inMemoryAuthentication().withUser("user").password("password").roles("USER");
//	}
	
//	@Override
//	  protected void configure(HttpSecurity http) throws Exception {
//	    http
//	      .csrf().disable()
//	      .authorizeRequests()
//	        .antMatchers(HttpMethod.POST, "/**").authenticated()
//	        .antMatchers(HttpMethod.PUT, "/**").authenticated()
//	        .antMatchers(HttpMethod.DELETE, "/**").authenticated()
//	        .anyRequest().permitAll();
//	        .and()
//	      .httpBasic().and()
//	      .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//	  }
}
