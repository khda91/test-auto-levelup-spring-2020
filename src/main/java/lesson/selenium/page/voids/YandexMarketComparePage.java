package lesson.selenium.page.voids;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class YandexMarketComparePage extends YandexMarketBasePage {

    @FindBy(className = "n-compare-head__name")
    private List<WebElement> productNames;

    public YandexMarketComparePage(WebDriver driver) {
        super(driver);
    }

    public List<String> getComparedProductNames() {
        return productNames
                .stream()
                .map(WebElement::getText)
                .collect(toList());
    }
}
