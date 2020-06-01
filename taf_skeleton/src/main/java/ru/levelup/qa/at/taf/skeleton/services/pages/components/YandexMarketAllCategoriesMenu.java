package ru.levelup.qa.at.taf.skeleton.services.pages.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import ru.levelup.qa.at.taf.skeleton.services.pages.YandexMarketBasePageElement;

import java.util.List;

public class YandexMarketAllCategoriesMenu extends YandexMarketBasePageElement {

    @FindBy(xpath = "//div[@data-zone-name='category-link']/button")
    private List<WebElement> mainMenuItems;

    @FindBy(css = "[data-autotest-id='subItems'] li")
    private List<WebElement> subItems;

    public YandexMarketAllCategoriesMenu(WebDriver driver) {
        super(driver);
    }

    public YandexMarketAllCategoriesMenu mouseHoverOnMenuItem(String menuItem) {
        for (WebElement mainMenuItem : mainMenuItems) {
            if (mainMenuItem.getText().equals(menuItem)) {
                new Actions(driver).moveToElement(mainMenuItem).perform();
                break;
            }
        }
        return new YandexMarketAllCategoriesMenu(driver);
    }

    public void clickSubMenuItem(String subItem) {
        for (WebElement mainMenuItem : subItems) {
            if (mainMenuItem.getText().equals(subItem)) {
                mainMenuItem.click();
                break;
            }
        }
    }

    public void clickOnMenuItem(String menuItem) {
        for (WebElement mainMenuItem : mainMenuItems) {
            if (mainMenuItem.getText().equals(menuItem)) {
                mainMenuItem.click();
                break;
            }
        }
    }

}
