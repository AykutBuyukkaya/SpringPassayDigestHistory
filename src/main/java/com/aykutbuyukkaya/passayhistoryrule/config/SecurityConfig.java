package com.aykutbuyukkaya.passayhistoryrule.config;

import org.cryptacular.bean.BCryptHashBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(10);
    }

    @Bean
    public BCryptHashBean bCryptHashBean(){
        return new BCryptHashBean();
    }

}
