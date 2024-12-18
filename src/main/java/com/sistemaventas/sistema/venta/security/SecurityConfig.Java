package com.sistemaventas.sistema.venta.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/*import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;*/

@Configuration
//@EnableWebSecurity
public class SecurityConfig {
/* 
  @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
        .csrf().disable()  
        .authorizeRequests(authorize -> authorize
            .requestMatchers("/admin/**").permitAll()  // Permite el acceso a todo lo que esté bajo /admin/
            .anyRequest().authenticated())  // Asegura que otras rutas requieran autenticación
        .formLogin(formLogin -> formLogin
            .loginPage("/login")
            .permitAll())
        .rememberMe(Customizer.withDefaults());
    
        return http.build();
    }
   */ 
}