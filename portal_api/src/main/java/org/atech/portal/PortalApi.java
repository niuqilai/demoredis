package org.atech.portal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//@EnableDiscoveryClient
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class},scanBasePackages = {"org.atech.portal","org.atech.facade"})
public class PortalApi
{
    public static void main(String[] args) {
        SpringApplication.run(PortalApi.class, args);
    }
}



