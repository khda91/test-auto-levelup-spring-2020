package lesson.selenium.allure;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import lesson.selenium.allure.steps.ActionSteps;
import lesson.selenium.allure.steps.AssertionSteps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public abstract class AbstractBaseTest {

    protected WebDriver driver;

    protected ActionSteps actionSteps;

    protected AssertionSteps assertionSteps;

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Step("Открыть Яндеск Маркет")
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://market.yandex.ru/");

        actionSteps = new ActionSteps(driver);
        assertionSteps = new AssertionSteps(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
