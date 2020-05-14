package lesson.selenium.allure.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class ActionSteps extends AbstractBaseStep {

    public ActionSteps(WebDriver driver) {
        super(driver);
    }

    @Step("Переход в категорию '{0}'")
    public void navigateToCategory(String categoryName) {
        yandexMarketHomePage.goToCategory(categoryName);
    }

    @Step("Переход в подкатегорию '{0}'")
    public void navigateToSubCategory(String subCategoryName) {
        yandexMarketCategoryPage.goToSubCategory(subCategoryName);
    }

    @Step("Добавить товар под номером '{0}' к сравнению")
    public String addProductToCompare(int indexOfTheProductOnThePage) {
        yandexMarketSubCategoryPage.getProductByIndex(indexOfTheProductOnThePage).addToCompare();
        return yandexMarketSubCategoryPage.getProductByIndex(indexOfTheProductOnThePage).getProductName();
    }

    @Step("Сравнить товары")
    public void compareSelectedProducts() {
        yandexMarketSubCategoryPage.clickCompareButton();
    }
}
