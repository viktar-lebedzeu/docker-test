package com.acantek.dockertest.common.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Application information bean
 * @author Viktar Lebedzeu
 */
@Data
@Component
@JsonInclude(JsonInclude.Include.NON_NULL)
@ConfigurationProperties(prefix = "application", ignoreUnknownFields = true)
public class ApplicationInfo {
    /** Group Id */
    private String groupId;
    /** Application name */
    private String name;
    /** Application version */
    private String version;
    /** Description */
    private String description;

    /** Service instance Id */
    private String serviceId;

    private ServiceInfo serviceDetails;
    private Object services;
}
