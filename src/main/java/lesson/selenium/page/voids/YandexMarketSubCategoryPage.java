package lesson.selenium.page.voids;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.openqa.selenium.By.className;
import static org.openqa.selenium.By.cssSelector;

public class YandexMarketSubCategoryPage extends YandexMarketBasePage {

    private static final By COMPARE_BUTTON_LOCATOR = cssSelector("div.n-product-toolbar__item");
    private static final By PRODUCT_TITLE_LOCATOR = className("n-snippet-card2__title");

    @FindBy(css = "div.n-snippet-card2")
    private List<WebElement> productsList;

    @FindBy(linkText = "Сравнить")
    private WebElement compareButton;

    public YandexMarketSubCategoryPage(WebDriver driver) {
        super(driver);
    }

    public void addToCompareByIndex(int productIndexOnThePage) {
        new Actions(driver)
                .moveToElement(productsList.get(productIndexOnThePage).findElement(COMPARE_BUTTON_LOCATOR))
                .click()
                .build()
                .perform();
    }

    public String getProductNameByIndex(int productIndexOnThePage) {
        return productsList.get(productIndexOnThePage).findElement(PRODUCT_TITLE_LOCATOR).getText();
    }

    public void clickCompareButton() {
        compareButton.click();
    }
}
