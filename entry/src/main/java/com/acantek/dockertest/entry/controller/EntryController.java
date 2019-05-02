package com.acantek.dockertest.entry.controller;

import com.acantek.dockertest.common.dto.ApplicationInfo;
import com.acantek.dockertest.common.dto.ServiceInfo;
import com.acantek.dockertest.common.service.CounterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest controller that process incoming HTTP requests
 * @author Viktar Lebedzeu
 */
@RestController
@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class EntryController {
    /** Logger */
    private static final Logger logger = LoggerFactory.getLogger(EntryController.class);

    /** Spring application environment */
    private final Environment env;
    /** Application (service) applicationInfo bean */
    private final ApplicationInfo applicationInfo;
    /** Counter */
    private final CounterService counterService;

    /*
    @Value("#{systemEnvironment['SERVICE_ID']}")
    private String serviceId;
    */

    @Autowired
    public EntryController(Environment env, ApplicationInfo applicationInfo, CounterService counterService) {
        this.env = env;
        this.applicationInfo = applicationInfo;
        this.counterService = counterService;
    }

    @GetMapping("/info")
    public @ResponseBody ResponseEntity<ApplicationInfo> getServiceInfo() {
        ServiceInfo serviceInfo = new ServiceInfo(applicationInfo.getServiceId(), counterService.getCounter());
        applicationInfo.setServiceDetails(serviceInfo);
        return new ResponseEntity<>(applicationInfo, HttpStatus.OK);
    }
}
