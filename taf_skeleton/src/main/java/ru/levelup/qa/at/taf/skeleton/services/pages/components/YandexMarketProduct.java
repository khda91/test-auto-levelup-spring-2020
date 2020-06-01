package ru.levelup.qa.at.taf.skeleton.services.pages.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import ru.levelup.qa.at.taf.skeleton.services.pages.YandexMarketBasePageElement;

import static org.openqa.selenium.By.className;
import static org.openqa.selenium.By.cssSelector;

public class YandexMarketProduct extends YandexMarketBasePageElement {

    private static final By COMPARE_BUTTON_LOCATOR = cssSelector("div.n-product-toolbar__item");
    private static final By PRODUCT_TITLE_LOCATOR = className("n-snippet-card2__title");

    private WebElement productItem;

    protected YandexMarketProduct(WebDriver driver) {
        super(driver);
    }

    public YandexMarketProduct(WebDriver driver, WebElement productItem) {
        super(driver);
        this.productItem = productItem;
    }

    public void addToCompare() {
        new Actions(driver)
                .moveToElement(productItem.findElement(COMPARE_BUTTON_LOCATOR))
                .click()
                .build()
                .perform();
    }

    public String getProductName() {
        return productItem.findElement(PRODUCT_TITLE_LOCATOR).getText();
    }

}
