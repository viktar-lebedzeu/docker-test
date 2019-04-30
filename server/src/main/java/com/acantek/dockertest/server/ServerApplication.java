package com.acantek.dockertest.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Viktar Lebedzeu
 */
@SpringBootApplication(scanBasePackages = "com.acantek.dockertest")
public class ServerApplication {
    public static void main(String... args) {
        SpringApplication.run(ServerApplication.class, args);
    }
}
