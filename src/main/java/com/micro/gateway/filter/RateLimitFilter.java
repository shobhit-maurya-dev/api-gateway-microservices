package com.micro.gateway.filter;

import com.micro.gateway.service.RateLimitService;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RateLimitFilter extends AbstractGatewayFilterFactory<Object> {

    private final RateLimitService rateLimitService;

    @Override
    public GatewayFilter apply(Object config) {

        return (exchange, chain) -> {

            String ip = exchange.getRequest()
                    .getRemoteAddress()
                    .getAddress()
                    .getHostAddress();

            String path = exchange.getRequest()
                    .getURI()
                    .getPath();

            String key = ip + ":" + path;

            if (!rateLimitService.allowRequest(key)) {

                exchange.getResponse().setStatusCode(HttpStatus.TOO_MANY_REQUESTS);
                return exchange.getResponse().setComplete();
            }

            return chain.filter(exchange);
        };
    }
}