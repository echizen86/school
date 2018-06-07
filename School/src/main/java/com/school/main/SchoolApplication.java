package com.school.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SchoolApplication extends SpringBootServletInitializer {
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SchoolApplication.class);
    }

	public static void main(String[] args) {
		SpringApplication.run(SchoolApplication.class, args);
	}

//	@SuppressWarnings("deprecation")
//	@Bean
//	public WebMvcConfigurer corsConfigurer() {
//		return new WebMvcConfigurerAdapter() {
//			@Override
//			public void addCorsMappings(CorsRegistry registry) {
//				registry.addMapping("/**").allowedOrigins("http://localhost:3000");
//			}
//		};
//	}
}
