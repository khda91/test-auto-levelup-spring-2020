package lesson.selenium.page.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class YandexMarketAllCategoriesMenu extends YandexMarketBasePageElement {

    @FindBy(xpath = "//div[@data-zone-name='category-link']/button")
    private List<WebElement> mainMenuItems;

    public YandexMarketAllCategoriesMenu(WebDriver driver) {
        super(driver);
    }

    public void mouseHoverOnMenuItem(String menuItem) {
        for (WebElement mainMenuItem : mainMenuItems) {
            if (mainMenuItem.getText().equals(menuItem)) {
                new Actions(driver).moveToElement(mainMenuItem).perform();
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
