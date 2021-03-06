package com.example.susziweb.Config;

import com.example.susziweb.Service.ApplicationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.concurrent.TimeUnit;

import static com.example.susziweb.auth.ApplicationUserRole.*;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final PasswordEncoder passwordEncoder;
    private final ApplicationUserService applicationUserService;

    @Autowired
    public SecurityConfig(PasswordEncoder passwordEncoder, ApplicationUserService applicationUserService) {
        this.passwordEncoder = passwordEncoder;
        this.applicationUserService = applicationUserService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/css/**", "/js/**", "/assets/**","/resources/**").permitAll()
                .antMatchers("/sushi-web/api/**").hasRole(ADMIN.name())
                .antMatchers("/sushi-web/login",
                        "/sushi-web/",
                        "/sushi-web/library",
                        "/sushi-web/settings",
                        "/sushi-web/contact").hasRole(STUDENT.name())
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                    .loginPage("/sushi-web/login")
                    .permitAll()
                    .defaultSuccessUrl("/sushi-web", true)
                    .passwordParameter("login-password") //DEFAULT password
                    .usernameParameter("login-username") //DEFAULT username
                /*.and()
                .rememberMe() // 2 weeks
                    .tokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(21)) // 21 days - 3 weeks
                    .key("somethinkVerySecurited")
                    .rememberMeParameter("remember-me") //DEFAULT*/
                .and()
                .logout()
                    .logoutUrl("/sushi-web/logout")
                    .logoutRequestMatcher(new AntPathRequestMatcher("/sushi-web/logout", "GET"))
                    .clearAuthentication(true)
                    .invalidateHttpSession(true)
                    .deleteCookies("JSESSIONID", "remember-me")
                    .logoutSuccessUrl("/sushi-web/login");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder);
        provider.setUserDetailsService(applicationUserService);

        return provider;
    }
}
