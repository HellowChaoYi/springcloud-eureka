package com.wei.filters;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

/**
 * 全局过滤器
 * 所有请求都会执行
 * 可拦截get、post等请求做逻辑处理
 */
@Component
public class RequestGlobalFilter implements GlobalFilter,Ordered {

	@Override
	public int getOrder() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		// TODO Auto-generated method stub
		ServerHttpRequest request = exchange.getRequest();
	    String uri = request.getURI().toString();
	    System.out.println(" uri : " + uri);
	    return chain.filter(exchange);
	}
	
}
