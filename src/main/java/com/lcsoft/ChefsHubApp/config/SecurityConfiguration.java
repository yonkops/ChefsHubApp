package com.lcsoft.ChefsHubApp.config;

import com.lcsoft.ChefsHubApp.model.repository.UserRepository;
import com.lcsoft.ChefsHubApp.service.impl.CustomUserDetailsService;
import com.lcsoft.ChefsHubApp.web.UserLoginController;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
    /*private final String rememberMeKey;*/
    /*private final UserDetailsService userDetailsService;*/
    private final UserRepository userRepository;
    //private final AuthenticationManager authenticationManager;

    public SecurityConfiguration(/*@Value("${chefshub.remember.me.key}") String rememberMeKey,*/ /*UserDetailsService userDetailsService,*/ UserRepository userRepository) {
        /*this.rememberMeKey = rememberMeKey;*/
        this.userRepository = userRepository;
        /*this.userDetailsService = userDetailsService(userRepository);*/
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

/*
    @Bean
    public UserLoginController userLoginAuth(AuthenticationManager authenticationManager) {
        return new UserLoginController(authenticationManager);
    }
*/

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }

    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepository) {
        return new CustomUserDetailsService(userRepository, passwordEncoder());
    }


    /*@Bean
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService(userRepository)).passwordEncoder(passwordEncoder());
    }*/

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // Configuring security rules
        return http.authorizeHttpRequests(
                authorizeRequests -> authorizeRequests
                        // Allow access to static resources (e.g., CSS, JavaScript) for all users
                        .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                        // Allow access to specific endpoints for all users
                        .requestMatchers("/", "/users/login", "/users/register").permitAll()
                        .requestMatchers("/error").permitAll()
                        .requestMatchers("/recipes/add").authenticated()
                        //.requestMatchers("/admin/**").hasRole(RoleType.ADMIN.name())
                        //.requestMatchers("/users/**").hasRole(RoleType.COMMON_USER.name())
                        // Require authentication for any other request
                        .anyRequest().authenticated()
        ).formLogin(
                formLogin -> {
                    formLogin
                            // Configure login page and form parameters
                            .loginPage("/users/login")
                            .usernameParameter("email")
                            .passwordParameter("password")
                            .defaultSuccessUrl("/")
                            .failureForwardUrl("/user/login-error");
                }
        ).logout(
                logout -> {
                    logout
                            // Configure logout URL and success URL
                            .logoutUrl("/users/logout")
                            .logoutSuccessUrl("/")
                            // Invalidate the HTTP session upon logout
                            .invalidateHttpSession(true);
                }
        )/*.rememberMe(
                rememberMe -> {
                    rememberMe
                            .key(rememberMeKey)
                            .rememberMeParameter("rememberme")
                            .rememberMeCookieName("rememberme");
                }
        )*/.build();
    }


}
