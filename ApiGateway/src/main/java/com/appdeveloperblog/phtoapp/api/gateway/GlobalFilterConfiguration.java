package com.appdeveloperblog.phtoapp.api.gateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import reactor.core.publisher.Mono;

@Configuration
public class GlobalFilterConfiguration {

	final Logger logger = LoggerFactory.getLogger(GlobalFilterConfiguration.class);

	@Order(1)
	@Bean
	public GlobalFilter secondPreFilter() {
		return (exchange, chain) -> {

			logger.info("My Second pre--filter executed..");

			return chain.filter(exchange).then(Mono.fromRunnable(() -> {
				logger.info("My Second post--filter executed..");

			}));

		};

	}

	@Order(2)
	@Bean
	public GlobalFilter thirdPreFilter() {
		return (exchange, chain) -> {

			logger.info("My Third pre--filter executed..");

			return chain.filter(exchange).then(Mono.fromRunnable(() -> {
				logger.info("My Third post--filter executed..");

			}));

		};

	}
	
	@Order(3)
	@Bean
	public GlobalFilter fourthPreFilter() {
		return (exchange, chain) -> {

			logger.info("My Fourth pre--filter executed..");

			return chain.filter(exchange).then(Mono.fromRunnable(() -> {
				logger.info("My Fourth post--filter executed..");

			}));

		};

	}
}
