package lesson.selenium.fluent;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import static org.openqa.selenium.remote.BrowserType.CHROME;
import static org.openqa.selenium.remote.BrowserType.FIREFOX;

public abstract class AbstractSeleniumBaseTest {

    protected WebDriver driver;

    @BeforeSuite
    public void setUpSuite() {
        final String browserName = System.getenv("browser.name") == null
                ? "chrome"
                : System.getenv("browser.name").toLowerCase();
        switch (browserName) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                break;

            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                break;
        }
    }

    @BeforeMethod
    public void setUpTest() {
        final String browserName = System.getenv("browser.name") == null
                ? "chrome"
                : System.getenv("browser.name").toLowerCase();

        switch (browserName) {
            case CHROME:
                driver = new ChromeDriver();
                break;

            case FIREFOX:
                driver = new FirefoxDriver();
                break;
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
    }

    @AfterMethod
    public void tearDownBrowser() {
        driver.quit();
    }
}