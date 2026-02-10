package io.github.giodmz.springarchitecture;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication
@EnableConfigurationProperties
public class Application {

	public static void main(String[] args) {

		// SpringApplication.run(Application.class, args);
		SpringApplicationBuilder builder = new SpringApplicationBuilder(Application.class);
		builder.bannerMode(Banner.Mode.OFF); // remove o banner do spring
		builder.profiles("1", "2");
		builder.run(args);


		// app context
		ConfigurableApplicationContext appContext = builder.context();
		// var productRepository = appContext.getBean("productRepository");
		builder.properties("spring.datasource.url=jdbc://");

		ConfigurableEnvironment environment = appContext.getEnvironment(); // can read any properties
		String appName = environment.getProperty("spring.application.name");
		System.out.println("App name: " + appName);

		Value value = appContext.getBean(Value.class);
		value.printVar();

		AppProperties properties = appContext.getBean(AppProperties.class);
		System.out.println(properties.getValor1());
	}

}
