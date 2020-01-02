package org.sid.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	/*
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		BCryptPasswordEncoder bCryptPasswordEncoder = getBCPE();
		auth.inMemoryAuthentication().withUser("admin").password(bCryptPasswordEncoder.encode("1234")).roles("ADMIN","USER");
		auth.inMemoryAuthentication().withUser("user").password(bCryptPasswordEncoder.encode("1234")).roles("USER");
		
	}*/
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	http.csrf().disable();
	http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	http.authorizeRequests().antMatchers("/categories/**").hasAnyAuthority("ADMIN");
	http.authorizeRequests().antMatchers("/products/**").hasAuthority("USER");
	http.authorizeRequests().anyRequest().authenticated();
	http.addFilterBefore(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
		super.configure(http);
	}
	
	/*@Bean
	public BCryptPasswordEncoder getBCPE()
	{
		return new BCryptPasswordEncoder();
	}*/
	
	

}
