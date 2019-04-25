package com.acantek.dockertest.controller;

import com.acantek.dockertest.dto.ApplicationInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Viktar Lebedzeu
 */
@RestController
public class ApplicationInfoController {
    /** Logger */
    private static final Logger logger = LoggerFactory.getLogger(ApplicationInfoController.class);

    @GetMapping(name = "/info")
    @ResponseBody
    public ApplicationInfo getApplicationInfo() {
        return new ApplicationInfo();
    }
}
