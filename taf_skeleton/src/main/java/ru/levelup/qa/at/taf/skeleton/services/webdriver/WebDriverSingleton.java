package ru.levelup.qa.at.taf.skeleton.services.webdriver;

import org.openqa.selenium.WebDriver;

public final class WebDriverSingleton {
    
    private static final WebDriverSingleton INSTANCE = new WebDriverSingleton();
    
    private WebDriver driver;
    
    private WebDriverSingleton() {
        
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public static WebDriverSingleton getInstance() {
        return INSTANCE;
    }
}
