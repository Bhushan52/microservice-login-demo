package com.appdeveloperblog.phtoapp.api.gateway;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Component
public class MyPreFilter implements GlobalFilter, Ordered {

	private static final Logger logger = LoggerFactory.getLogger(MyPreFilter.class);

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

		String requestPath = exchange.getRequest().getPath().toString();
		logger.info("Request path is :{}", requestPath);

		HttpHeaders httHeaders = exchange.getRequest().getHeaders();

		Set<String> headers = httHeaders.keySet();
		for (String headerName : headers) {

			String headerValue = httHeaders.getFirst(headerName);

			logger.info("Header Name:{} Header Value: {}", headerName, headerValue);

		}
		return chain.filter(exchange);
	}

	@Override
	public int getOrder() {
		return 5;
	}

}
