package com.hronom.coolhub.coolhubuser.config;

import com.hronom.coolhub.coolhubuser.properties.ApplicationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({ApplicationProperties.class})
public class ApplicationConfig {
}
