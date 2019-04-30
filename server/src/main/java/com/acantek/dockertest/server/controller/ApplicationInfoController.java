package com.acantek.dockertest.server.controller;

import com.acantek.dockertest.dto.ApplicationInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Viktar Lebedzeu
 */
@RestController
@RequestMapping("/api")
public class ApplicationInfoController {
    /** Logger */
    private static final Logger logger = LoggerFactory.getLogger(ApplicationInfoController.class);

    private final ApplicationInfo applicationInfo;

    @Autowired
    public ApplicationInfoController(ApplicationInfo applicationInfo) {
        this.applicationInfo = applicationInfo;
    }

    @GetMapping("/info")
    public ResponseEntity<ApplicationInfo> getApplicationInfo() {
        return new ResponseEntity<>(applicationInfo, HttpStatus.OK);
    }
}
