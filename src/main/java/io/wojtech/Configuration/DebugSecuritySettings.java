package io.wojtech.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


/**
 * Created by user on 2017-08-26.
 */

@EnableWebSecurity
public class DebugSecuritySettings extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable(); //TODO: for production, must be reconfigured in order to disable only in specific cases. This line was added because without it, HTTP POST requests did not work.

    }

}

