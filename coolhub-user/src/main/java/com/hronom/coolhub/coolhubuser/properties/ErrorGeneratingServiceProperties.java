package com.hronom.coolhub.coolhubuser.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties("error-generating-service")
public class ErrorGeneratingServiceProperties {

    private boolean generateErrors;

    public boolean isGenerateErrors() {
        return generateErrors;
    }

    public void setGenerateErrors(boolean generateErrors) {
        this.generateErrors = generateErrors;
    }
}
