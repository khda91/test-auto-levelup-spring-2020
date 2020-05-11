package lesson.selenium.page.objects1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YandexMarketHomePage {

    private WebDriver driver;

    public YandexMarketHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public YandexMarketResultPage searchItem(String item) {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("header-search")))
                .sendKeys(item);
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@action='/search']//div[text()='Найти']/..")))
                .click();
        return new YandexMarketResultPage(driver);
    }

    public YandexMarketElectronicPage goToElectronicPage() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(By.linkText("Электроника"))).click();
        return new YandexMarketElectronicPage(driver);
    }
}
