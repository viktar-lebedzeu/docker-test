package com.acantek.dockertest.dockertest.dto;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Viktar Lebedzeu
 */
@Data
@Component
@ConfigurationProperties(prefix = "application", ignoreUnknownFields = false)
public class ApplicationInfo {
    /** Group Id */
    private String groupId;
    /** Application name */
    private String name;
    /** Application version */
    private String version;
    /** Description */
    private String description;
}
