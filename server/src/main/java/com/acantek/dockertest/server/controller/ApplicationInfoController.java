package com.acantek.dockertest.server.controller;

import com.acantek.dockertest.common.dto.ApplicationInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
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
@RestController
@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ApplicationInfoController {
    /** Logger */
    private static final Logger logger = LoggerFactory.getLogger(ApplicationInfoController.class);

    private final ApplicationInfo applicationInfo;
    private final DiscoveryClient discoveryClient;

    @Autowired
    public ApplicationInfoController(ApplicationInfo applicationInfo, DiscoveryClient discoveryClient) {
        this.applicationInfo = applicationInfo;
        this.discoveryClient = discoveryClient;
    }

    @GetMapping("/info")
    public ResponseEntity<ApplicationInfo> getApplicationInfo() {
        final List<ServiceInstance> clients = discoveryClient.getInstances("docker-test-entry");
        applicationInfo.setServices(clients);
        return new ResponseEntity<>(applicationInfo, HttpStatus.OK);
    }
}
