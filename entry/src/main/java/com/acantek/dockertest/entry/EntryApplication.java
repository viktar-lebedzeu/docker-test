package com.acantek.dockertest.entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * Spring boot application of Entry point controllers.
 * @author Viktar Lebedzeu
 */
@SpringBootApplication(scanBasePackages = "com.acantek.dockertest")
@EnableDiscoveryClient
@EnableHystrix
public class EntryApplication {
    private final DiscoveryClient discoveryClient;

    @Autowired
    public EntryApplication(DiscoveryClient discoveryClient) {
        this.discoveryClient = discoveryClient;
    }

    public static void main(String... args) {
        SpringApplication.run(EntryApplication.class, args);
    }
}
