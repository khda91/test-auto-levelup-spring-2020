package ru.levelup.qa.at.taf.skeleton.services.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.levelup.qa.at.taf.skeleton.services.pages.components.YandexMarketProduct;
import ru.levelup.qa.at.taf.skeleton.services.webdriver.WebDriverSingleton;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElementsLocatedBy;

public class YandexMarketSubCategoryPage extends YandexMarketBasePage {

    private static final String CHECK_BOXES_XPATH = "//fieldset//input[contains(@name, 'Морозильная')]/..";
    
    private static YandexMarketSubCategoryPage instance;

//    @FindBy(css = properties.get("products.list.css"))
    @FindBy(css = "div.n-snippet-card2")
    private List<WebElement> productsList;
    
    @FindBy(linkText = "Сравнить")
    private WebElement compareButton;
    
    @FindBy(xpath = CHECK_BOXES_XPATH)
    private List<WebElement> checkBoxes;

    private YandexMarketSubCategoryPage(WebDriver driver) {
        super(driver);
    }

    public boolean isSortedLinksVisible() {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
        List<WebElement> until = new WebDriverWait(driver, configuration.explicitlyTimeout())
                .until(visibilityOfAllElementsLocatedBy(By.className("n-filter-sorter__link12")));
        driver.manage().timeouts().implicitlyWait(configuration.implicitlyTimeout(), TimeUnit.MILLISECONDS);
        return until != null;
    }

    public YandexMarketProduct getProductByIndex(int productIndexOnThePage) {
        return new YandexMarketProduct(driver, productsList.get(productIndexOnThePage));
    }

    public void clickCompareButton() {
        new WebDriverWait(driver, configuration.explicitlyTimeout())
                .until(elementToBeClickable(compareButton))
                .click();
    }

    public void selectCheckbox(String checkboxTitle) {
        for (WebElement checkBox : checkBoxes) {
            if (checkBox.getText().contains(checkboxTitle)) {
                new WebDriverWait(driver, configuration.explicitlyTimeout())
                        .until(elementToBeClickable(checkBox)).click();
                break;
            }
        }
    }

    public static YandexMarketSubCategoryPage getInstance() {
        if (instance == null) {
            instance = new YandexMarketSubCategoryPage(WebDriverSingleton.getInstance().getDriver());
        }
        return instance;
    }
}
