package com.acantek.dockertest.entry;

import com.acantek.dockertest.common.dto.ApplicationInfo;
import com.acantek.dockertest.common.dto.ServiceInfo;
import com.acantek.dockertest.common.service.CounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Controller;

/**
 * @author Viktar Lebedzeu
 */
@Controller
public class ServiceInfoContributor implements InfoContributor {
    private final ApplicationInfo applicationInfo;
    private final CounterService counterService;

    @Autowired
    public ServiceInfoContributor(ApplicationInfo applicationInfo, CounterService counterService) {
        this.applicationInfo = applicationInfo;
        this.counterService = counterService;
    }

    @Override
    public void contribute(Info.Builder builder) {
        builder.withDetail("application", applicationInfo);
        builder.withDetail("service", new ServiceInfo(applicationInfo.getServiceId(), counterService.getCounter()));
    }
}
