package lesson.design.patterns.singleton;

import org.openqa.selenium.WebDriver;

public enum WebDriverSingleton {

    INSTANCE;

    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
}
