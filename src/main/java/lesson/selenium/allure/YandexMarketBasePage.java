package lesson.selenium.allure;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public abstract class YandexMarketBasePage extends YandexMarketBasePageElement {

    @FindBy(css = "[data-zone-name='category-link']")
    private List<WebElement> categoryLinks;

    @FindBy(css = "[data-zone-name='all-categories']")
    private WebElement allCategoriesButton;

    protected YandexMarketBasePage(WebDriver driver) {
        super(driver);
    }

    public void goToCategory(String item) {
        for (WebElement categoryLink : categoryLinks) {
            if (categoryLink.getText().equals(item)) {
                categoryLink.click();
                break;
            }
        }
    }

    public YandexMarketAllCategoriesMenu clickAllCategoriesButton() {
        allCategoriesButton.click();
        return new YandexMarketAllCategoriesMenu(driver);
    }
}