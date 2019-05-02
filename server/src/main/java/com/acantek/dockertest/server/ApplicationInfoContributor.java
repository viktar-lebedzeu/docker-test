package com.acantek.dockertest.server;

import com.acantek.dockertest.common.dto.ApplicationInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Viktar Lebedzeu
 */
@Component
public class ApplicationInfoContributor implements InfoContributor {

    private final ApplicationInfo applicationInfo;
    private final DiscoveryClient discoveryClient;

    @Autowired
    public ApplicationInfoContributor(ApplicationInfo applicationInfo, DiscoveryClient discoveryClient) {
        this.applicationInfo = applicationInfo;
        this.discoveryClient = discoveryClient;
    }

    @Override
    public void contribute(Info.Builder builder) {
        final List<ServiceInstance> entryClients = discoveryClient.getInstances("docker-test-entry");
        builder.withDetail("application", applicationInfo);
        builder.withDetail("entries", entryClients);
    }
}
