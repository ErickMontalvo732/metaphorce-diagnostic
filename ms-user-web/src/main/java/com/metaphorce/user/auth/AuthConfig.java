package com.metaphorce.user.auth;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class AuthConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .authorizeRequests( (authHttp ) -> authHttp
                        .requestMatchers(HttpMethod.GET,"/authorized").permitAll()
                        .requestMatchers(HttpMethod.GET, "/getUsers").hasAnyAuthority("SCOPE_read", "SCOPE_write")
                        .requestMatchers(HttpMethod.POST, "/createUser").hasAuthority("SCOPE_write")
                        .anyRequest().authenticated())
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(session -> session.sessionCreationPolicy( SessionCreationPolicy.STATELESS))
                .oauth2Login( login -> login.loginPage("/oauth2/authorization/user-web"))
                .oauth2Client(withDefaults())
                .oauth2ResourceServer(resource -> resource.jwt(withDefaults()))
        ;
        return http.build();


    }
}
