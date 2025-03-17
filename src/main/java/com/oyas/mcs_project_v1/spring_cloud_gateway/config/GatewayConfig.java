package com.oyas.mcs_project_v1.spring_cloud_gateway.config;

import org.springframework.cloud.gateway.filter.ratelimit.RedisRateLimiter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {

        return builder
                .routes()
                .route("users-route", r -> r.path("/api/v1/users/**")
                        .uri("lb://USER-SERVICE")) /* Load-balanced request to user service (this tells the gateway to use eureka's service discovery instead of a fixed url) */
                .build();
    }

}