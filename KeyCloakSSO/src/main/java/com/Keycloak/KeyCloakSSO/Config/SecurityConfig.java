package com.Keycloak.KeyCloakSSO.Config;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;


@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((auth) -> auth
                .requestMatchers("/account", "/balance", "/loans", "/cards").authenticated().
                requestMatchers("/notices", "/contact").permitAll()
        ).formLogin(withDefaults());
        return http.build();

        // The below code is to permit all the requests whch is not good for production applications

//        http.authorizeHttpRequests((auth) -> auth
//                .anyRequest().permitAll()).httpBasic(Customizer.withDefaults());
//
//        return http.build();

        // the below code is used to deny all the request,  not sugessted for production applications
//        http.authorizeHttpRequests((auth) -> auth
//                .anyRequest().denyAll()).httpBasic(Customizer.withDefaults());
//
//        return http.build();
    }

}
