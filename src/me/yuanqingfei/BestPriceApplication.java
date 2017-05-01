package me.yuanqingfei;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Entry Point. 
 * 
 * 
 * @author aaron
 *
 */
@SpringBootApplication
public class BestPriceApplication extends SpringBootServletInitializer{
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(BestPriceApplication.class);
	}

	public static void main(String[] args) {
		new BestPriceApplication()
				.configure(new SpringApplicationBuilder(BestPriceApplication.class))
				.run(args);
	}
}
