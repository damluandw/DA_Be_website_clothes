package com.bkap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication(scanBasePackages = { "com.bkap" })
@EnableConfigurationProperties({
	FileStorageProperties.class
})
public class JbDoanShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(JbDoanShopApplication.class, args);
	}

}
