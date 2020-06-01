package ru.levelup.qa.at.taf.skeleton.services.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.levelup.qa.at.taf.skeleton.configuration.WebDriverConfiguration;
import ru.levelup.qa.at.taf.skeleton.configuration.WebDriverConfigurationProvider;

public abstract class YandexMarketBasePageElement {

    protected WebDriver driver;
    
    protected WebDriverConfiguration configuration;

    protected YandexMarketBasePageElement(WebDriver driver) {
        this.driver = driver;
        configuration = WebDriverConfigurationProvider.getInstance().getConfiguration();
        PageFactory.initElements(driver, this);
    }
}
