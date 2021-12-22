package ru.grakovich.filmland.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserDetailsService userDetailsServiceImpl;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

        http.authorizeRequests()
                    .antMatchers("/viewing/**").authenticated()
                    .antMatchers("/films").permitAll()
                    .antMatchers("/files/**").permitAll()
                    .antMatchers("/film/**").hasAuthority("ADMIN")
                    .antMatchers("/film_add").hasAuthority("ADMIN")
                    .antMatchers("/filmUpdate/**").hasAuthority("ADMIN")
                    .antMatchers("/actor").permitAll()
                    .antMatchers("/director").permitAll()
                    .antMatchers("/signUp").permitAll()
                    .antMatchers("/signIn").permitAll()
                    .and()
                    .formLogin()
                    .loginPage("/signIn")
                    .usernameParameter("email")
                    .passwordParameter("password")
                    .defaultSuccessUrl("/")
                    .permitAll();
    }
}
