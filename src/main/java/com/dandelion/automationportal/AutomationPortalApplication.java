package com.dandelion.automationportal;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;

@EnableEncryptableProperties
@SpringBootApplication
public class AutomationPortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutomationPortalApplication.class, args);
	}

}
