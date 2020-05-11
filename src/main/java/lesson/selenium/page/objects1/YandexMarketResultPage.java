package lesson.selenium.page.objects1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YandexMarketResultPage {

    private WebDriver driver;

    public YandexMarketResultPage(WebDriver driver) {
        this.driver = driver;
    }

    // Смартфон  iPhone 7 128GB
    public String getPhoneName() {
        return new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Смартфон  iPhone 7 128GB']")))
                .getText();
    }
}
