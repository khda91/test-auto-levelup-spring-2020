package lesson.selenium.page.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class YandexMarketSubCategoryPage extends YandexMarketBasePage {

    @FindBy(css = "div.n-snippet-card2")
    private List<WebElement> productsList;

    @FindBy(linkText = "Сравнить")
    private WebElement compareButton;

    public YandexMarketSubCategoryPage(WebDriver driver) {
        super(driver);
    }

    public YandexMarketProduct getProductByIndex(int productIndexOnThePage) {
        return new YandexMarketProduct(driver, productsList.get(productIndexOnThePage));
    }

    public void clickCompareButton() {
        new WebDriverWait(driver, 5)
                .until(elementToBeClickable(compareButton))
                .click();
    }
}
