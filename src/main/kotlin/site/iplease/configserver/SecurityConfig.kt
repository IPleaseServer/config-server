package site.iplease.configserver

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.SecurityFilterChain

@Configuration
class SecurityConfig {
    @Bean
    fun configure(http: HttpSecurity): SecurityFilterChain =
    http
            .formLogin()
            .and()
            .authorizeRequests()
            .antMatchers("/actuator/**").hasRole("ADMIN")
            .anyRequest().permitAll()
            .and()
            .cors().disable()
            .csrf().disable()
        .build()
}