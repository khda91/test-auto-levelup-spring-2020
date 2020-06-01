package ru.levelup.qa.at.taf.skeleton.test.steps;

import io.qameta.allure.Step;
import ru.levelup.qa.at.taf.skeleton.services.pages.YandexMarketCategoryPage;
import ru.levelup.qa.at.taf.skeleton.services.pages.YandexMarketHomePage;
import ru.levelup.qa.at.taf.skeleton.services.pages.YandexMarketSubCategoryPage;

public final class ActionSteps extends AbstractBaseStep {

    private static ActionSteps instance;

    private ActionSteps() {
    }

    @Step("Переход в категорию '{0}'")
    public void navigateToCategory(String categoryName) {
        YandexMarketHomePage.getInstance().goToCategory(categoryName);
    }

    @Step("Переход в подкатегорию '{0}'")
    public void navigateToSubCategory(String subCategoryName) {
        YandexMarketCategoryPage.getInstance().goToSubCategory(subCategoryName);
    }

    @Step("Добавить товар под номером '{0}' к сравнению")
    public String addProductToCompare(int indexOfTheProductOnThePage) {
        YandexMarketSubCategoryPage.getInstance().getProductByIndex(indexOfTheProductOnThePage).addToCompare();
        return YandexMarketSubCategoryPage.getInstance().getProductByIndex(indexOfTheProductOnThePage).getProductName();
    }

    @Step("Сравнить товары")
    public void compareSelectedProducts() {
        YandexMarketSubCategoryPage.getInstance().clickCompareButton();
    }

    public static ActionSteps actionSteps() {
        if (instance == null) {
            instance = new ActionSteps();
        }
        return instance;
    }
}
