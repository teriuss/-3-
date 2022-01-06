package com.buildstore.Buildstore.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("ayana")
                .password("{noop}1234")
                .roles("DELIVERY")
                .and()
                .withUser("adil")
                .password("{noop}123")
                .roles("PRORAB");
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers("/AllmaterialsProrab").hasRole("PRORAB")
                .antMatchers("/Delivery_End_Prorab").hasRole("PRORAB")
                .antMatchers("/MaterialDetails").hasRole("PRORAB")
                .antMatchers("/MaterialEdit").hasRole("PRORAB")
                .antMatchers("/ProrabHome").hasRole("PRORAB")
                .antMatchers("/Delivery_Materials").hasRole("DELIVERY")
                .antMatchers("/Delivery_End").hasRole("DELIVERY")
                .antMatchers("/DeliveryHome").hasRole("DELIVERY")
                .antMatchers("/Salary").hasRole("DELIVERY")
                .antMatchers("/OwnerHome").permitAll()
                .antMatchers("/").permitAll()
                .antMatchers("/EnterProrab").permitAll()
                .antMatchers("/EnterDelivery").permitAll()
                .anyRequest().authenticated()
                .and().formLogin();
    }


}
