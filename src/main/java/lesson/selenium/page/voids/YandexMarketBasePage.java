package lesson.selenium.page.voids;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public abstract class YandexMarketBasePage {

    protected WebDriver driver;

    @FindBy(css = "[data-zone-name='category-link']")
    private List<WebElement> categoryLinks;

    protected YandexMarketBasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goToCategory(String item) {
        for (WebElement categoryLink : categoryLinks) {
            if (categoryLink.getText().equals(item)) {
                categoryLink.click();
                break;
            }
        }
    }
}