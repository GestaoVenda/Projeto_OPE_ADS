package br.com.opeads;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;

import br.com.opeads.filter.AuthFilter;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class ProjetoOpeAdsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoOpeAdsApplication.class, args);
	}
	
	@Bean
	public FixedLocaleResolver localeResolver(){
		return new FixedLocaleResolver(new Locale("pt","BR"));
	}
	
	@Bean
	public FilterRegistrationBean filtroJWT(){
		FilterRegistrationBean frb = new FilterRegistrationBean();
		frb.setFilter(new AuthFilter());
		frb.addUrlPatterns("/api/list/*","/api/save/*","/api/edit/*","/api/delete/*");
		return frb;
	}
}
