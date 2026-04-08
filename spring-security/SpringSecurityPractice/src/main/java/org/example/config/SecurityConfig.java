package org.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests( c -> c
                        .anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults());

        /*http.formLogin()
                .defaultSuccessUrl("/bauth/greetings")
                .and().authorizeHttpRequests(c -> c.anyRequest().authenticated())
                .csrf(csrf -> csrf.disable())
                .httpBasic(Customizer.withDefaults());*/

        return http.build();

    }

    @Bean
    public UserDetailsService user(){
        UserDetails user = User.withUsername("Durga")
                .password("$2a$10$3UI3WRBHTO3VeYNzrw62vuelulMn0hpFEQAnNZqWrzxIXBKfXqFzy").build();
//                .password("pass123").build();

        UserDetails user2 = User.withUsername("Ram")
                .password(passwordEncoder().encode("ram123")).build();

        UserDetails user3 = User.withUsername("Sameer")
                .password(passwordEncoder().encode("sam123")).build();

        return new InMemoryUserDetailsManager(user, user2, user3);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return  new BCryptPasswordEncoder();
    }

}
