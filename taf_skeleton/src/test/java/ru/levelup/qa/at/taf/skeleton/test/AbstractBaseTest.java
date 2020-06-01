package ru.levelup.qa.at.taf.skeleton.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import ru.levelup.qa.at.taf.skeleton.configuration.WebDriverConfiguration;
import ru.levelup.qa.at.taf.skeleton.configuration.WebDriverConfigurationProvider;
import ru.levelup.qa.at.taf.skeleton.services.webdriver.WebDriverFactory;
import ru.levelup.qa.at.taf.skeleton.services.webdriver.WebDriverSingleton;

public abstract class AbstractBaseTest {

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Step("Открыть Яндеск Маркет")
    public void setUp() {
        WebDriverConfiguration webDriverConfiguration = WebDriverConfigurationProvider.getInstance().getConfiguration();
        WebDriverSingleton.getInstance().setDriver(WebDriverFactory.getInstance().createDriver(webDriverConfiguration.browserName()));
        WebDriverSingleton.getInstance().getDriver().get(webDriverConfiguration.siteUrl());
    }

    @AfterMethod
    public void tearDown() {
        WebDriverSingleton.getInstance().getDriver().quit();
    }
}
