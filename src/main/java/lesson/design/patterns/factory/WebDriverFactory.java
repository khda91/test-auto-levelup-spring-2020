package lesson.design.patterns.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public final class WebDriverFactory {

    private WebDriverFactory() {
    }

    public static WebDriver createDriver(final String browserName) {
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

    private static WebDriver createChromeDriver() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    private static WebDriver createFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

    private static WebDriver createSafariDriver() {
        return new SafariDriver();
    }

}
