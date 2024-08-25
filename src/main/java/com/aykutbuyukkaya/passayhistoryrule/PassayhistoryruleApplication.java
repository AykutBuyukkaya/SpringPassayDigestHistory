package com.aykutbuyukkaya.passayhistoryrule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class PassayhistoryruleApplication {

    public static void main(String[] args) {
        SpringApplication.run(PassayhistoryruleApplication.class, args);
    }

}
