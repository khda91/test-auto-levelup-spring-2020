package ru.levelup.qa.at.taf.skeleton.services.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.levelup.qa.at.taf.skeleton.services.webdriver.WebDriverSingleton;

public class YandexMarketCategoryPage extends YandexMarketBasePage {

    private static YandexMarketCategoryPage instance;

    private YandexMarketCategoryPage() {
        super(WebDriverSingleton.getInstance().getDriver());
    }

    public void goToSubCategory(String subCategory) {
        new WebDriverWait(driver, configuration.explicitlyTimeout())
                .until(ExpectedConditions.elementToBeClickable(By.linkText(subCategory))).click();
    }

    public static YandexMarketCategoryPage getInstance() {
        if (instance == null) {
            instance = new YandexMarketCategoryPage();
        }
        return instance;
    }
}
