package com.acantek.dockertest.eureka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author Viktar Lebedzeu
 */
@SpringBootApplication(scanBasePackages = "com.acantek.dockertest")
@EnableEurekaServer
public class EurekaServiceApplication {
    /** Logger */
    private static final Logger logger = LoggerFactory.getLogger(EurekaServiceApplication.class);

    /**
     * Spring boot application entry point
     * @param args Application arguments
     */
    public static void main(String... args) {
        SpringApplication.run(EurekaServiceApplication.class, args);
    }
}
