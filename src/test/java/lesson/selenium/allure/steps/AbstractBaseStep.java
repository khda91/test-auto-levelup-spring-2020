package lesson.selenium.allure.steps;

import lesson.selenium.allure.YandexMarketCategoryPage;
import lesson.selenium.allure.YandexMarketComparePage;
import lesson.selenium.allure.YandexMarketHomePage;
import lesson.selenium.allure.YandexMarketSubCategoryPage;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractBaseStep {

    protected static List<String> expectedProductNames = new ArrayList<>();

    protected WebDriver driver;

    YandexMarketHomePage yandexMarketHomePage;

    YandexMarketCategoryPage yandexMarketCategoryPage;

    YandexMarketSubCategoryPage yandexMarketSubCategoryPage;

    YandexMarketComparePage yandexMarketComparePage;

    protected AbstractBaseStep(WebDriver driver) {
        this.driver = driver;
        yandexMarketHomePage = new YandexMarketHomePage(driver);
        yandexMarketCategoryPage = new YandexMarketCategoryPage(driver);
        yandexMarketSubCategoryPage = new YandexMarketSubCategoryPage(driver);
        yandexMarketComparePage = new YandexMarketComparePage(driver);
    }
}
