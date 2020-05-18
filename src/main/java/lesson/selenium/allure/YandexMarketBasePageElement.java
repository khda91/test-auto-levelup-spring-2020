package lesson.selenium.allure;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class YandexMarketBasePageElement {

    protected WebDriver driver;

    protected YandexMarketBasePageElement(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}