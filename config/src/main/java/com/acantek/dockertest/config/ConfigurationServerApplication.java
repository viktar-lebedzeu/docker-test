package com.acantek.dockertest.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Spring cloud Configuration server application
 * @author Viktar Lebedzeu
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigurationServerApplication {
    /**
     * Main application entry point
     * @param args Command line parameters
     */
    public static void main(String... args) {
        SpringApplication.run(ConfigurationServerApplication.class, args);
    }
}
