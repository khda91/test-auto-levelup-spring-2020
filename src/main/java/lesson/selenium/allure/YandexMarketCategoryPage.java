package lesson.selenium.allure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YandexMarketCategoryPage extends YandexMarketBasePage {

    public YandexMarketCategoryPage(WebDriver driver) {
        super(driver);
    }

    public void goToSubCategory(String subCategory) {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(By.linkText(subCategory))).click();
    }
}
