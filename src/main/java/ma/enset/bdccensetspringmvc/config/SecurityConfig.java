package ma.enset.bdccensetspringmvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder() { // This bean is used to encode passwords
        return new BCryptPasswordEncoder();
    }
    // You can define your security configurations here
    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        PasswordEncoder encoder = passwordEncoder();
        return  new InMemoryUserDetailsManager(
                User.withUsername("nboutachrafine")
                        .password(passwordEncoder().encode("2020"))
                        .roles("USER")
                        .build(),
                User.withUsername("tboutachrafine")
                        .password(passwordEncoder().encode("2020"))
                        .roles("USER")
                        .build(),
                User.withUsername("aboutachrafine")
                        .password(passwordEncoder().encode("2020"))
                        .roles("USER,ADMIN")
                        .build()
        );
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.formLogin(Customizer.withDefaults())
                .authorizeHttpRequests(authoHttpRequests ->
                        authoHttpRequests.requestMatchers("/user/**").hasRole("USER")
                                .requestMatchers("/admin/**").hasRole("ADMIN")
                                .requestMatchers("/public/**").permitAll()
                                .anyRequest().authenticated())
                .build();
    }
}
