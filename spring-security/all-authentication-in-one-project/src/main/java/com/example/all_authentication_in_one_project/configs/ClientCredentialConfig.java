package com.example.all_authentication_in_one_project.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class ClientCredentialConfig {

   /* @Bean
    public JwtAuthenticationConverter jwtAuthenticationConverter() {
        JwtGrantedAuthoritiesConverter converter = new JwtGrantedAuthoritiesConverter();

        // Azure puts application permissions in "roles"
        converter.setAuthoritiesClaimName("roles");

        // Spring Security prefix
        converter.setAuthorityPrefix("ROLE_");

        JwtAuthenticationConverter jwtAuthConverter = new JwtAuthenticationConverter();
        jwtAuthConverter.setJwtGrantedAuthoritiesConverter(converter);

        return jwtAuthConverter;
    }*/


    @Bean
    public SecurityFilterChain clientCredFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .securityMatcher("/clientcred/**")
                .authorizeHttpRequests(auth-> auth
                        .anyRequest().authenticated())
//                        .anyRequest().hasAnyAuthority("ROLE_api.read", "ROLE_api.write"))
//                .oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults()));
//                .oauth2ResourceServer(oauth2 -> oauth2.jwt(jwt -> jwt.jwtAuthenticationConverter(jwtAuthenticationConverter())));
                //jwt ->
                  //      jwt.jwtAuthenticationConverter(jwtAuthenticationConverter())));
                .oauth2ResourceServer(oauth -> oauth.jwt(Customizer.withDefaults()));


        return http.build();
    }
}
