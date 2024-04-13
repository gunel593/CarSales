package com.example.CarSales.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration{
    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails user= User.withUsername("user")
                .password(passwordEncoder().encode("user123"))
              .roles("USER")
                .build();
        UserDetails admin= User.withUsername("admin")
                .password(passwordEncoder().encode("admin1223"))
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user,admin);
    }
//    @Autowired
//    public void globalConfig(AuthenticationManagerBuilder auth)throws Exception{
//        auth.inMemoryAuthentication().
//                withUser("Admin")
//                .password(passwordEncoder().encode("admin1234"));
//
//    }

public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
}
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .httpBasic(Customizer.withDefaults())
                .csrf(httpSecurityCsrfConfigurer -> httpSecurityCsrfConfigurer.disable())
                .authorizeHttpRequests(
                        authManager -> authManager
                 .requestMatchers("/car-sales/no-auth", "/car-sales/no-auth/id/**" )
                                .permitAll()
                                .requestMatchers("/car-sales/admin/id/**")
                                .hasRole("ADMIN")
                                .anyRequest()
                     .hasRole("USER")
                )
                .build();
    }
}
