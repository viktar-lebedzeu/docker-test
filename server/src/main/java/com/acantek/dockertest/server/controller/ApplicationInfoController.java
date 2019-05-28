package com.acantek.dockertest.server.controller;

import com.acantek.dockertest.common.dto.ApplicationInfo;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Viktar Lebedzeu
 */
@RefreshScope
@RestController
@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Slf4j
public class ApplicationInfoController {
    private final ApplicationInfo applicationInfo;
    private final DiscoveryClient discoveryClient;

    @Value("${application.descriptionMessage:}")
    private String appDescriptionMessage;

    @Value("${eureka.client.proxyHost:localhost}")
    private String eurekaClientHost;

    @Autowired
    public ApplicationInfoController(ApplicationInfo applicationInfo, DiscoveryClient discoveryClient) {
        this.applicationInfo = applicationInfo;
        this.discoveryClient = discoveryClient;
    }

    @GetMapping("/info")
    public ResponseEntity<ApplicationInfo> getApplicationInfo() {
        log.info("App description    : {}", appDescriptionMessage);
        log.info("eureka client host : {}", eurekaClientHost);
        final List<ServiceInstance> clients = discoveryClient.getInstances("docker-test-entry");
        applicationInfo.setServices(clients);
        return new ResponseEntity<>(applicationInfo, HttpStatus.OK);
    }
}
