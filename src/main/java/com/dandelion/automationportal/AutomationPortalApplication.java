package com.dandelion.automationportal;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableEncryptableProperties
@SpringBootApplication
@EnableCaching
public class AutomationPortalApplication {

    public static void main(String[] args) {
        SpringApplication.run(AutomationPortalApplication.class, args);
    }
}
