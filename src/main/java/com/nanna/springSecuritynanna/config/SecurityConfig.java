package com.nanna.springSecuritynanna.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

//@EnableWebSecurity
@Configuration
@EnableMethodSecurity()
public class SecurityConfig {

    
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder ();
    }
    
    
    
    
    
    
    
    
    @Bean
    public UserDetailsService userDetailsService() {
    
//    userdetailsservice implementation
        UserDetails normalUser = User
                .withUsername ( "nanna" )
                .password ( passwordEncoder () .encode ( "nanna32100" ))
                .roles ( "normal" )
                .build ();
        UserDetails adminUser = User
                .withUsername ( "admin" )
                .password ( passwordEncoder ().encode ( "admin" ) )
                .roles ( "admin" )
                .build ();
    
            return  new InMemoryUserDetailsManager ( normalUser , adminUser );
    
    
        
        
    }
    
    
    
    

    @Bean
    public SecurityFilterChain securityFilterChain( HttpSecurity httpSecurity ) throws Exception {
    
        httpSecurity.csrf ().disable ()
                .authorizeHttpRequests()
//                .requestMatchers ( "/home/admin" )
//                .hasRole ( "admin" )
//                .requestMatchers ( "/home/normal" )
//                .hasRole ( "normal" )
                .requestMatchers ( "/home/public" )
                .permitAll ()
                .anyRequest ()
                .authenticated ()
                .and ()
                .formLogin ();
        
        return httpSecurity.build ();
        
    }

}
