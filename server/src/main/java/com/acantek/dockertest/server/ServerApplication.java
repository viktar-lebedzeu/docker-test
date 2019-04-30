package com.acantek.dockertest.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Viktar Lebedzeu
 */
@SpringBootApplication(scanBasePackages = "com.acantek.dockertest")
@EnableEurekaClient
/*
@EnableDiscoveryClient
@EnableHystrix
@EnableHystrixDashboard
@EnableCircuitBreaker
*/
public class ServerApplication {
    public static void main(String... args) {
        SpringApplication.run(ServerApplication.class, args);
    }
}
