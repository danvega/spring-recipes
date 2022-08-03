package dev.danvega.randomcoffeedeclarative;

import dev.danvega.randomcoffeedeclarative.client.CoffeeClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CoffeeClient coffeeClient() throws Exception {
		WebClient webClient = WebClient.builder()
				.baseUrl("https://coffee.alexflipnote.dev")
				.build();

		HttpServiceProxyFactory factory = WebClientAdapter.createHttpServiceProxyFactory(webClient);
		factory.afterPropertiesSet();

		return factory.createClient(CoffeeClient.class);
	}
}
