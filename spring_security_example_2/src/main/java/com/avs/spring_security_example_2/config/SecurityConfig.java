package com.avs.spring_security_example_2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // to specify this is a configuration
@EnableWebSecurity // To run app with configuration done below
public class SecurityConfig {
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        /*Customizer<CsrfConfigurer<HttpSecurity>> custCsrf = new Customizer<CsrfConfigurer<HttpSecurity>>() {
            @Override
            public void customize(CsrfConfigurer<HttpSecurity> customizer){
                customizer.disable();
            }
        };
        http.csrf(custCsrf); */
        // The above commented code is for disabling csrf if not done using the below code

        http.csrf(customizer -> customizer.disable()); // disable csrf, basically no security
        http.authorizeHttpRequests(request -> request.anyRequest().authenticated()); // securing all routes, access to routes will be denied. also at this point since no means of authentication, we cannot do anything with the api
        // http.formLogin(Customizer.withDefaults()); // enable form login with defaults 
        http.httpBasic(Customizer.withDefaults()); // enable to do authentication in postman. if form login is disabled, this will give a pop up and will work unlike te page
        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)); // new session id for each req. This means you cannot authenticate with form login
        return http.build();

        // can also use builder pattern for all methods of http
    }

    @Bean
    public UserDetailsService userDetailsService(){

        UserDetails user1 = User
         .withDefaultPasswordEncoder()
         .username("sabarish")
         .password("123")
         .roles("USER")
         .build();
        UserDetails user2 = User
         .withDefaultPasswordEncoder()
         .username("av")
         .password("123")
         .roles("ADMIN")
         .build();

        return new InMemoryUserDetailsManager(user1, user2);
    }


}