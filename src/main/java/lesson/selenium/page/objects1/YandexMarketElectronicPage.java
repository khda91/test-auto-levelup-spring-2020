package lesson.selenium.page.objects1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YandexMarketElectronicPage {

    private WebDriver driver;

    public YandexMarketElectronicPage(WebDriver driver) {
        this.driver = driver;
    }

    public YandexMarketMobilePhonePage goToMobilePhonePage() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(By.linkText("Мобильные телефоны"))).click();
        return new YandexMarketMobilePhonePage(driver);
    }
}
