package com.Keycloak.KeyCloakSSO.Config;

import com.Keycloak.KeyCloakSSO.Controllers.NoticesController;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
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

    @Bean
    public InMemoryUserDetailsManager userDetailsServices(){
        UserDetails admin = User.withUsername("admin")
                .password("12345")
                .authorities("admin")
                .build();
        UserDetails user = User.withUsername("user")
                .password("12345")
                .authorities("read")
                .build();
        return new InMemoryUserDetailsManager(admin, user);

    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }


}
