/**
 * 
 */
package com.mycompany.boot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author NishantS
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	/**
	 * Specify Security resources mapping and congifurations
	 */
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/styles/**", "/images/**", "/scripts/**", "/index").permitAll()
				.antMatchers(HttpMethod.POST,"/person/**").hasRole("ADMIN")
				.antMatchers(HttpMethod.PUT,"/person/**").hasAnyRole("ADMIN","USER")
				.antMatchers(HttpMethod.DELETE,"/person/**").hasRole("ADMIN")
				.anyRequest().permitAll().and()
				.csrf().disable()
			.formLogin()
				.loginPage("/login")
				.permitAll()
				.failureUrl("/login")
				.and()
			.httpBasic().and()	
			.logout()
                .permitAll();
	}

	@Override
	/**
	 * specify securith provide configurations
	 */
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.inMemoryAuthentication()
			.withUser("admin").password("admin").roles("ADMIN")
			.and()
			.withUser("user").password("user").roles("USER");
	}
}
