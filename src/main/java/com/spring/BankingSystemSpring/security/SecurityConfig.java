package com.spring.BankingSystemSpring.security;

import com.spring.BankingSystemSpring.Entity.Client;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager()
    {
        UserDetails amr = User.builder().username("amr")
            .password("{noop}test").roles("client").build();

        UserDetails ahmed = User.builder().username("ahmed")
                .password("{noop}test").roles("employee").build();
        return new InMemoryUserDetailsManager(amr,ahmed);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer->
                configurer.requestMatchers(HttpMethod.GET,"/clientapi/clients").hasAnyRole("employee","client")
                        .requestMatchers(HttpMethod.GET,"/accountapi/accounts").hasRole("client")
                        .requestMatchers(HttpMethod.GET,"/transactionapi/transactions").hasAnyRole("employee","client")
                        .requestMatchers(HttpMethod.POST,"/transactionapi/transactions").hasRole("client")
                        .requestMatchers(HttpMethod.PUT,"/transactionapi/transactions").hasRole("employee")
                        .requestMatchers(HttpMethod.DELETE,"/transactionapi/transactions").hasRole("employee")
                );
        //for HTTP basic authentication
        http.httpBasic(Customizer.withDefaults());

        //CSRF is a type of attack where a malicious website can send a request to another website
        // where the victim is already authenticated
        // if you are building a stateless REST API or a single-page application that uses a token-based authentication mechanism.
        // In these cases, disabling CSRF protection can simplify the code and avoid unnecessary overhead.
        http.csrf(csrf -> csrf.disable());
        return http.build();
    }

}
