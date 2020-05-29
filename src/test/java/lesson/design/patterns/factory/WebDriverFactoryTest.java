package lesson.design.patterns.factory;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebDriverFactoryTest {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        String property = System.getProperty("browser.name");
        String browserName = property != null ? property : "chrome";
        driver = WebDriverFactory.createDriver(browserName);
    }

    @Test
    public void chromeDriverTest() throws InterruptedException {
        driver.navigate().to("https://yandex.ru");
        Thread.sleep(4000);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
