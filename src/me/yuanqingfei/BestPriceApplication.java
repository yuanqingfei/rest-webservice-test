package me.yuanqingfei;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Entry Point. 
 * 
 * 
 * @author aaron
 *
 */
@SpringBootApplication
public class BestPriceApplication extends SpringBootServletInitializer{
	

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
