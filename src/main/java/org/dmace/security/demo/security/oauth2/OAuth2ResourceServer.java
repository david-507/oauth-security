package org.dmace.security.demo.security.oauth2;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@Configuration
@EnableResourceServer
public class OAuth2ResourceServer extends ResourceServerConfigurerAdapter {

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) {
		
		resources.resourceId("oauth2-resource");
		
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {

		http
		.csrf()
			.disable()
		.sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
		.authorizeRequests()
			//.antMatchers(HttpMethod.POST, "/oauth/token").permitAll()
			.antMatchers(HttpMethod.GET, "/demo/**").hasRole("USER")
			.anyRequest().authenticated();

	
	}

	
	
}