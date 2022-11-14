package com.example.demo.config;

import com.example.demo.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

     @Autowired
     private CustomUserDetailsService customUserDetailsService;


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("home/**").permitAll()
                .antMatchers("users/**").hasRole("ADMIN")
                .antMatchers("/all/**").hasRole("USER")
                .anyRequest()
                .authenticated()
                .and()
                .formLogin();

    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       /*
        auth.inMemoryAuthentication().withUser("rao").password(this.passwordEncoder().encode("12345")).roles("ADMIN");
        auth.inMemoryAuthentication().withUser("musa").password(this.passwordEncoder().encode("123")).roles("USER");
   */
          auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());

    }

    /*
    @Bean
    public PasswordEncoder passwordEncoder(){

        return new BCryptPasswordEncoder(10);

    }
*/

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){

        return new BCryptPasswordEncoder(10);

    }


}
