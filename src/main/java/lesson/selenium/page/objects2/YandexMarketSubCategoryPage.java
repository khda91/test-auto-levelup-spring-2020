package lesson.selenium.page.objects2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YandexMarketSubCategoryPage extends YandexMarketBasePage {

    public YandexMarketSubCategoryPage(WebDriver driver) {
        super(driver);
    }

    public String getFirstPhoneName() {
        return new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Смартфон  iPhone 7 32GB']")))
                .getText();
    }
}
