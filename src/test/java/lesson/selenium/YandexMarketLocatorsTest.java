package lesson.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class YandexMarketLocatorsTest {

    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://market.yandex.ru/");
    }

    @Test
    public void idLocatorTest() {
        WebElement searchTextField = driver.findElement(By.id("header-search"));
//        WebElement searchTextField = driver.findElement(By.cssSelector("#header-search"));
        searchTextField.sendKeys("мыло");
        try {
            TimeUnit.MILLISECONDS.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void classNameLocatorTest() {
        driver.get("http://users.bugred.ru/");
        WebElement label = driver.findElement(By.className("newlink"));
//        WebElement label = driver.findElement(By.cssSelector(".newlink"));
        System.out.println(label.getText());
        try {
            TimeUnit.MILLISECONDS.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void linkTextLocatorTest() {
        WebElement label = driver.findElement(By.linkText("Маркет"));
        System.out.println(label.getText());
        try {
            TimeUnit.MILLISECONDS.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
