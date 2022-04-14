package com.example.sttudy_jpa;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration//빈등록: 스프링 컨테이너에서 객체에서 관리
@EnableWebSecurity/////필터를 추가해준다
public class securityConfig extends WebSecurityConfigurerAdapter {

@Bean
@Override
public AuthenticationManager authenticationManagerBean() throws Exception {
    // TODO Auto-generated method stub
    return super.authenticationManagerBean();
}
    @Bean
    public BCryptPasswordEncoder pwdEncoder() {
       return  new BCryptPasswordEncoder();
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
             .csrf().disable()
            //.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
            //.and()
           // .addFilter(corsFilter.crosfilter())
            //.addFilter(new loginFilter(jwtService,authenticationManager(),redisTemplate,access_token_cookie_name,refresh_token_cookie_name))
           // .addFilter(new authorizationFilter(authenticationManager(),jwtService,redisTemplate,access_token_cookie_name,refresh_token_cookie_name))
            //.csrf().disable()
            
            .formLogin().disable().httpBasic().disable()
            .authorizeRequests().antMatchers("/admin/**").access("ROLE_ADMIN").antMatchers("/user/**").authenticated() 
            .anyRequest().permitAll();

    }
}
