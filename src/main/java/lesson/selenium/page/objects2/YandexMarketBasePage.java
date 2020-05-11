package lesson.selenium.page.objects2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class YandexMarketBasePage {

    protected WebDriver driver;

    protected YandexMarketBasePage(WebDriver driver) {
        this.driver = driver;
    }

//    public YandexMarketResultPage searchItem(String item) {
//        new WebDriverWait(driver, 10)
//                .until(ExpectedConditions.visibilityOfElementLocated(By.id("header-search")))
//                .sendKeys(item);
//        new WebDriverWait(driver, 10)
//                .until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@action='/search']//div[text()='Найти']/..")))
//                .click();
//        return new YandexMarketResultPage(driver);
//    }

    public YandexMarketCategoryPage goToCategory(String item) {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(By.linkText(item))).click();
        return new YandexMarketCategoryPage(driver);
    }
}