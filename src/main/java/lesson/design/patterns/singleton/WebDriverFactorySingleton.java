package lesson.design.patterns.singleton;

import io.github.bonigarcia.wdm.WebDriverManager;
import lesson.design.patterns.factory.BrowserName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public final class WebDriverFactorySingleton {

    private static WebDriverFactorySingleton instance;

    private WebDriverFactorySingleton() {
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

    public static WebDriverFactorySingleton getInstance() {
        if (instance == null) {
            instance = new WebDriverFactorySingleton();
        }
        return instance;
    }
}
