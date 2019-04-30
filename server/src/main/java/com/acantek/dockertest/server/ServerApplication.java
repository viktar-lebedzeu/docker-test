package com.acantek.dockertest.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author Viktar Lebedzeu
 */
@SpringBootApplication(scanBasePackages = "com.acantek.dockertest")
@EnableDiscoveryClient
@EnableZuulProxy
@EnableHystrixDashboard
@EnableCircuitBreaker
@EnableTurbine
public class ServerApplication {
    public static void main(String... args) {
        SpringApplication.run(ServerApplication.class, args);
    }
}
