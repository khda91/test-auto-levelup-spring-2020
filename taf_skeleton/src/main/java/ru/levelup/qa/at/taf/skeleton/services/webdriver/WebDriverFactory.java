package ru.levelup.qa.at.taf.skeleton.services.webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public final class WebDriverFactory {

    private static final WebDriverFactory INSTANCE = new WebDriverFactory();
    
    private WebDriverFactory() {
    }

    public WebDriver createDriver(final String browserName) {
        switch (BrowserName.getBrowserName(browserName)) {
            case CHROME:
                return createChromeDriver();

            case FIREFOX:
                return createFirefoxDriver();

            case SAFARI:
                return createSafariDriver();

            default:
                throw new IllegalArgumentException(String.format("Unknown browser '%s'", browserName));
        }
    }

    private WebDriver createChromeDriver() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    private WebDriver createFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

    private WebDriver createSafariDriver() {
        return new SafariDriver();
    }
    
    public static WebDriverFactory getInstance() {
        return INSTANCE;
    }

}
