// package com.example.DemoSpringBoot.configs;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
// import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.web.access.AccessDeniedHandler;

// import com.example.DemoSpringBoot.exceptionz.CustomAccessDeniedHandler;
// import com.example.DemoSpringBoot.services.UserServiceImpl;

// @Configuration
// @EnableWebSecurity
// public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

//     @Autowired
//     private AccessDeniedHandler accessDeniedHandler;

//     @Autowired
//     private UserServiceImpl uService;

//     @Override
//     protected void configure(HttpSecurity http) throws Exception {
//         http.csrf().disable().authorizeRequests()
//                 .antMatchers("api/v1/public").permitAll()
//                 .antMatchers("api/v1/private").authenticated()
//                 .anyRequest().permitAll()
//                 .and()
//                 .exceptionHandling().accessDeniedHandler(accessDeniedHandler());
//     }

//     @Autowired
//     public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//         BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//         auth.userDetailsService(uService).
//         ;
//     }

//     private AccessDeniedHandler accessDeniedHandler() {
//         return new CustomAccessDeniedHandler();
//     }

// }
