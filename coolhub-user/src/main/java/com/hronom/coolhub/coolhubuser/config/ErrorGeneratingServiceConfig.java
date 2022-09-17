package com.hronom.coolhub.coolhubuser.config;

import com.hronom.coolhub.coolhubuser.properties.ErrorGeneratingServiceProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({ErrorGeneratingServiceProperties.class})
public class ErrorGeneratingServiceConfig {
    // Beans declaration
}
