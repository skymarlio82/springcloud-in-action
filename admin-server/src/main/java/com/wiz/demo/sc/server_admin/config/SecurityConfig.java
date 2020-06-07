
package com.wiz.demo.sc.server_admin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import de.codecentric.boot.admin.server.config.AdminServerProperties;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private String adminContextPath = "";

	public void SecuritySecureConfig(AdminServerProperties asp) {
        this.adminContextPath = asp.getContextPath();
    }

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		SavedRequestAwareAuthenticationSuccessHandler sraash = new SavedRequestAwareAuthenticationSuccessHandler();
		sraash.setTargetUrlParameter("redirectTo");
		httpSecurity.authorizeRequests()
			.antMatchers(adminContextPath + "/assets/**")
			.permitAll()
			.antMatchers(adminContextPath + "/login")
			.permitAll()
			.anyRequest()
			.authenticated()
			.and()
			.formLogin()
			.loginPage(adminContextPath + "/login")
			.successHandler(sraash)
			.and()
			.logout()
			.logoutUrl(adminContextPath + "/logout")
			.and()
			.httpBasic()
			.and()
			.csrf()
			.disable();
	}
}