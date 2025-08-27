package com.example.Online.Billing.Symtem.Pahana.Edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
// Add this annotation to tell Spring where your entities are
@EntityScan("com.example.Online.Billing.Symtem.Pahana.Edu.entity")
// Add this annotation to tell Spring where your repositories are
@EnableJpaRepositories("com.example.Online.Billing.Symtem.Pahana.Edu.repository")
public class OnlineBillingSymtemPahanaEduApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(OnlineBillingSymtemPahanaEduApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(OnlineBillingSymtemPahanaEduApplication.class);
	}
}
