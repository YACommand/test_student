package ru.innopolis.stc13.student_test.config;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.innopolis.stc13.student_test.service.UserService;
import ru.innopolis.stc13.student_test.service.UserServiceImpl;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserServiceImpl userService;

    final static Logger LOOGGER = Logger.getLogger(UserService.class);

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/resources/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .usernameParameter("j_username")
                .passwordParameter("j_password").successHandler((req, res, auth) -> {    //Success handler invoked after successful authentication
            for (GrantedAuthority authority : auth.getAuthorities()) {
                LOOGGER.info(authority.getAuthority());
            }
            LOOGGER.info(auth.getName());
            res.sendRedirect("/"); // Redirect user to index/home page
        })
                .failureHandler((req, res, exp) -> {  // Failure handler invoked after authentication failure
                    String errMsg = "";
                    if (exp.getClass().isAssignableFrom(BadCredentialsException.class)) {
                        errMsg = "Invalid username or password.";
                    } else {
                        errMsg = "Unknown error - " + exp.getMessage();
                    }
                    req.getSession().setAttribute("message", errMsg);
                    res.sendRedirect("/login"); // Redirect user to login page with error message.
                })
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService)
                .passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
