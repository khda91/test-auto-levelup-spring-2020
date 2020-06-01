package ru.levelup.qa.at.taf.skeleton.configuration;

import org.aeonbits.owner.ConfigFactory;

public class WebDriverConfigurationProvider {
    
    private static WebDriverConfigurationProvider instance;
    
    private WebDriverConfiguration configuration;

    private WebDriverConfigurationProvider() {
        configuration = ConfigFactory.newInstance().create(WebDriverConfiguration.class);
    }

    public WebDriverConfiguration getConfiguration() {
        return configuration;
    }

    public static WebDriverConfigurationProvider getInstance() {
        if (instance == null) {
            instance = new WebDriverConfigurationProvider();
        }
        return instance;
    }
}
