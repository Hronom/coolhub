package com.hronom.coolhub.coolhubuser.service;

import com.hronom.coolhub.coolhubuser.properties.ErrorGeneratingServiceProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ErrorGeneratingService {

    private final ErrorGeneratingServiceProperties errorGeneratingServiceProperties;

    @Autowired
    public ErrorGeneratingService(
            ErrorGeneratingServiceProperties errorGeneratingServiceProperties
    ) {
        this.errorGeneratingServiceProperties = errorGeneratingServiceProperties;
    }

    public void triggerSimpleError() throws Exception {
        if (errorGeneratingServiceProperties.isGenerateErrors()) {
            throw new IllegalStateException("Generated error");
        }
    }
}
