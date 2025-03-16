package com.oyas.mcs_project_v1.mcs_project_spring_cloud_gateway.config;

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
                        .uri("http://localhost:9494"))
                .build();
    }
}