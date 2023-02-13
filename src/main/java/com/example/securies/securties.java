package com.example.securies;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity (prePostEnabled = true)
public class securties  extends WebSecurityConfigurerAdapter{
	
	
	@Override
	@Bean
	public UserDetailsService userDetailsServiceBean() throws Exception {

		UserDetails userDetails = User.builder().username("suresh")
				.password("{noop}12345")
				.roles("mba")
				.build();
		UserDetails user = User.builder().username("KSB")
				.password("{noop}123456")
				.roles("USER")
				.build();
		
		return new InMemoryUserDetailsManager(userDetails, user);
	}
	
	 protected void configure(HttpSecurity http) throws Exception {
	                 http
	                .csrf().disable()
	                .authorizeRequests()
	                .antMatchers(HttpMethod.GET, "/api/**").permitAll()
	                .antMatchers("/api/auth/**").permitAll()
	                .anyRequest()
	                .authenticated();
	    }
		
	}


