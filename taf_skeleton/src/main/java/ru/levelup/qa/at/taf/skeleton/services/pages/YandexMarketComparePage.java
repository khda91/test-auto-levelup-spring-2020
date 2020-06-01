package ru.levelup.qa.at.taf.skeleton.services.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.levelup.qa.at.taf.skeleton.services.webdriver.WebDriverSingleton;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class YandexMarketComparePage extends YandexMarketBasePage {

    private static YandexMarketComparePage instance;
    
    @FindBy(className = "n-compare-head__name")
    private List<WebElement> productNames;

    private YandexMarketComparePage() {
        super(WebDriverSingleton.getInstance().getDriver());
    }

    public List<String> getComparedProductNames() {
        return productNames
                .stream()
                .map(WebElement::getText)
                .collect(toList());
    }
    
    public static YandexMarketComparePage getInstance() {
        if (instance == null) {
            instance = new YandexMarketComparePage();
        }
        return instance;
    }
}
