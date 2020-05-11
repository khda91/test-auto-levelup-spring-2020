package lesson.selenium.core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.io.File;

import static org.testng.Assert.assertEquals;

public class YandexMarketSimpleTest {

    @Test
    public void checkYandexMarketTitleTest() {
//        System.setProperty("webdriver.chrome.driver",
//                this.getClass().getClassLoader().getResource("selenium/chromedriver").getPath());
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://market.yandex.ru/");
        assertEquals(driver.getTitle(), "Яндекс.Маркет — выбор и покупка товаров из проверенных интернет-магазинов");
        driver.quit();
    }

    @Test
    public void checkYandexMarketTitleHeadlessTest() {
//        System.setProperty("webdriver.chrome.driver",
//                this.getClass().getClassLoader().getResource("selenium/chromedriver").getPath());
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions()
                .addArguments("--start-maximized")
                .setHeadless(true);
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.navigate().to("https://market.yandex.ru/");
        assertEquals(driver.getTitle(), "Яндекс.Маркет — выбор и покупка товаров из проверенных интернет-магазинов");
        driver.quit();
    }

    @Test
    public void chromeExtensionTest() {
//        System.setProperty("webdriver.chrome.driver",
//                this.getClass().getClassLoader().getResource("selenium/chromedriver").getPath());
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions()
                .addExtensions(new File(this.getClass()
                        .getClassLoader().getResource("selenium/chrome_extensions/pdf_viewer_extension.crx").getPath()));
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.navigate().to("https://www.oracle.com/technetwork/java/codeconventions-150003.pdf");
        assertEquals(driver.getTitle(), "codeconventions-150003.pdf");
        driver.quit();
    }

    @Test
    public void checkYandexMarketTitleCloseTest() {
//        System.setProperty("webdriver.chrome.driver",
//                this.getClass().getClassLoader().getResource("selenium/chromedriver").getPath());
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://market.yandex.ru/");
        for (int i = 0; i < 5; i++) {
            new Actions(driver).keyDown(Keys.CONTROL).sendKeys("T").build().perform();
        }
        assertEquals(driver.getTitle(), "Яндекс.Маркет — выбор и покупка товаров из проверенных интернет-магазинов");
        driver.close();
    }
}
