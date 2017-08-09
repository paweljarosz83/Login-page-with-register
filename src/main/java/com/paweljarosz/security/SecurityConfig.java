package com.paweljarosz.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.LocaleResolver;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	public void configureAuth(AuthenticationManagerBuilder auth) throws Exception{
		auth
		//.inMemoryAuthentication().withUser("aaaa").password("aaaa").roles("USER");
		.userDetailsService(userDetailsService);
		//.passwordEncoder(new BCryptPasswordEncoder());
	}
	
	@Override
	public void configure(HttpSecurity  http) throws Exception{
		http
			.authorizeRequests()
				.antMatchers(HttpMethod.GET,"/","/css/**","/images/**").permitAll()
				.antMatchers("/").permitAll()
				.antMatchers("/index").permitAll()
				.antMatchers("/register").permitAll()
				.antMatchers("/forgot").permitAll()
				.antMatchers("/user/changePassword").permitAll()
				.antMatchers("/resetPasswordFailed").permitAll()
				.antMatchers("/terms").permitAll()
				.antMatchers("/learnMore").permitAll()
				
				.antMatchers("/admin/**").hasRole("ADMIN")
				.anyRequest().authenticated()
				.and()
				.formLogin()
				.loginPage("/login")
				.usernameParameter("username")
				.permitAll()
				.and()
				.logout()
				.logoutUrl("/logout")
				.logoutSuccessUrl("/login?logout")
				.permitAll();
	}
}
