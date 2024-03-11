package com.tipu.main.config;
import net.bytebuddy.build.Plugin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebSecurity
@ComponentScan("com.tipu.main.controller")
public class WebSecurityConfig implements WebMvcConfigurer {


    @Bean
    public UserDetailsService userDetailsService(){

        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();

        manager.createUser(User.withDefaultPasswordEncoder().username("tipu").password("7211").roles("USER").build());
        return manager;

    }


    protected void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/")
                .authorizeHttpRequests()
                .anyRequest().hasAnyRole("ADMIN")
                .and()
                .httpBasic();

    }
}
