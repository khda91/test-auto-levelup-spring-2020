package lesson.selenium.allure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElementsLocatedBy;

public class YandexMarketSubCategoryPage extends YandexMarketBasePage {

    @FindBy(css = "div.n-snippet-card2")
    private List<WebElement> productsList;

    @FindBy(linkText = "Сравнить")
    private WebElement compareButton;

    @FindBy(xpath = "//fieldset//input[contains(@name, 'Морозильная')]/..")
    private List<WebElement> checkBoxes;

    public YandexMarketSubCategoryPage(WebDriver driver) {
        super(driver);
    }

    public boolean isSortedLinksVisible() {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
        List<WebElement> until = new WebDriverWait(driver, 7)
                .until(visibilityOfAllElementsLocatedBy(By.className("n-filter-sorter__link12")));
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        return until != null;
    }

    public YandexMarketProduct getProductByIndex(int productIndexOnThePage) {
        return new YandexMarketProduct(driver, productsList.get(productIndexOnThePage));
    }

    public void clickCompareButton() {
        new WebDriverWait(driver, 5)
                .until(elementToBeClickable(compareButton))
                .click();
    }

    public void selectCheckbox(String checkboxTitle) {
        for (WebElement checkBox : checkBoxes) {
            if (checkBox.getText().contains(checkboxTitle)) {
                new WebDriverWait(driver, 5)
                        .until(elementToBeClickable(checkBox)).click();
                break;
            }
        }
    }
}
