package com.example.client_credential_manual_token_refresh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ClientCredentialManualTokenRefreshApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientCredentialManualTokenRefreshApplication.class, args);
	}

}
