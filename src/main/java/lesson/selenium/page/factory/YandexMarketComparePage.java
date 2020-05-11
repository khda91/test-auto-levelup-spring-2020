package lesson.selenium.page.factory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class YandexMarketComparePage {

    @FindBy(className = "n-compare-head__name")
    private List<WebElement> productNames;

    public List<String> getComparedProductNames() {
        return productNames
                .stream()
                .map(WebElement::getText)
                .collect(toList());
    }
}
