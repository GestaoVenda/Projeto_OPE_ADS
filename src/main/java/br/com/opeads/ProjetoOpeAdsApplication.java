package br.com.opeads;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class ProjetoOpeAdsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoOpeAdsApplication.class, args);
	}
}
