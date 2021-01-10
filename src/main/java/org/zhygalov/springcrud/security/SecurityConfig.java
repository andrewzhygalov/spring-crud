package org.zhygalov.springcrud.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
	private  UserDetailsService userDetailsService;
	
	@Autowired
	private SuccessHandler successHandler;
	
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }
	@Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
				.antMatchers("/admin/**").hasRole("ADMIN") 
                .antMatchers("/**").hasAnyRole("USER", "ADMIN")  
				.and().formLogin()
				.successHandler(successHandler);  
    }
	
	@Bean
	public PasswordEncoder passwordEncoder() {
        return  NoOpPasswordEncoder.getInstance();
    }  
}
