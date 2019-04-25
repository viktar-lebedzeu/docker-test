package com.acantek.dockertest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Viktar Lebedzeu
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
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
