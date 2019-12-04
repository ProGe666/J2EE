package com.example.SpringBootRestDemo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.SpringBootRestDemo.security.handles.AccessDeniedHandlerImpl;
import com.example.SpringBootRestDemo.security.handles.AuthenticationEntryPointImpl;
import com.example.SpringBootRestDemo.security.handles.AuthenticationFailureHandlerImpl;
import com.example.SpringBootRestDemo.security.handles.AuthenticationSuccessHandlerImpl;
import com.example.SpringBootRestDemo.security.handles.LogoutSuccessHandlerImpl;

@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class SecurityConfig extends WebSercurityConfigurerAdapter {
	@Autowired
	private UserDetailsService useDetailServiceImpl;
	public void conifgure(HttpEntity http) throws Exception{
        http
       
        .cors(	)
        	.and()
        .csrf().disable()
//        	.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
//			.and()

        @Autowired
        private AuthenticationEntryPointImpl authenticationEntryPointImpl;
        
        @Autowired
        private AccessDeniedHandlerImpl accessDeniedHandlerImpl;
        
        @Autowired
        private AuthenticationSuccessHandlerImpl authenticationSuccessHandlerImpl;
        
        @Autowired
        private AuthenticationFailureHandlerImpl authenticationFailureHandlerImpl;
        
        @Autowired
        private LogoutSuccessHandlerImpl logoutSuccessHandlerImpl;
        
        .authorizeRequests()
        	.anyMatchers(HttpMethod.GET,"/products","/index.html", "/").permitAll()
          	.anyMatchers(HttpMethod.GET,"/orders","/order/").hasRole("ADMIN")//.hasAuthority("ROLE_ADMIN")
            .anyRequest().authenticated()   //.permitAll()
            .and()
            

         .exceptionHandling()
         	.authenticationEntryPoint("")
         
         	.and()
        .formLogin().and()
        	.usernameParameter("username")
        	.passwordParameter("password")
        	.successHandler(autrnticationSuccessHandleerImpl)
        	.failureHandler(autrnticationFailureHandleerImpl)
        	.and()

        .logout()
            .permitAll()    
            .logoutUrl("/logout")
            .logoutSuccessHandler(logoutSuccessHandlerImpl)
            .and()



        .httpBasic();
	}
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(11);
		
	}
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

}
