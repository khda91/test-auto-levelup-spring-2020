package lesson.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class YandexMarketWaitsTest {

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
        driver.manage().timeouts().implicitlyWait(7500, TimeUnit.MILLISECONDS);
        long start = System.currentTimeMillis();
        WebElement label;
        try {
            label = driver.findElement(By.className("newlink1"));
        } finally {
            long end = System.currentTimeMillis();
            System.out.println(((end - start) / 1000));
        }
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
        WebElement label = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(By.linkText("Маркет")));
        WebElement label1 = new WebDriverWait(driver, 10, 2000)
                .until(ExpectedConditions.elementToBeClickable(By.linkText("Авто12")));
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
