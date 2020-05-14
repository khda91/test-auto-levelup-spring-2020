package lesson.selenium.page.elements;

import lesson.selenium.page.AbstractBaseTest;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.assertEqualsNoOrder;

public class SeleniumPageFactoryTest extends AbstractBaseTest {

    @Test
    public void compareProductsPageObjectTest() {
        List<String> expectedProductNames = new ArrayList<>();
        YandexMarketHomePage homePage = new YandexMarketHomePage(driver);
        homePage.goToCategory("Компьютеры");

        YandexMarketCategoryPage categoryPage = new YandexMarketCategoryPage(driver);
        categoryPage.goToSubCategory("Ноутбуки");

        YandexMarketSubCategoryPage subCategoryPage = new YandexMarketSubCategoryPage(driver);
        subCategoryPage.getProductByIndex(0).addToCompare();
        String firstProduct = subCategoryPage.getProductByIndex(0).getProductName();
        expectedProductNames.add(firstProduct);

        subCategoryPage.getProductByIndex(1).addToCompare();
        String secondProduct = subCategoryPage.getProductByIndex(1).getProductName();
        expectedProductNames.add(secondProduct);

        subCategoryPage.clickCompareButton();
        YandexMarketComparePage comparePage = PageFactory.initElements(driver, YandexMarketComparePage.class);
        List<String> actualProductNames = comparePage.getComparedProductNames();

//        assertEqualsNoOrder(actualProductNames.toArray(), expectedProductNames.toArray());
        assertThat(actualProductNames)
                .describedAs("List does not match")
                .containsExactlyInAnyOrderElementsOf(expectedProductNames);
    }

    @Test
    public void compareProductsPageObjectTest1() {
        List<String> expectedProductNames = new ArrayList<>();
        YandexMarketHomePage homePage = new YandexMarketHomePage(driver);
        YandexMarketAllCategoriesMenu yandexMarketAllCategoriesMenu = homePage.clickAllCategoriesButton();
        yandexMarketAllCategoriesMenu.mouseHoverOnMenuItem("Компьютерная техника");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        yandexMarketAllCategoriesMenu.clickOnMenuItem("Компьютерная техника");

        YandexMarketCategoryPage categoryPage = new YandexMarketCategoryPage(driver);
        categoryPage.goToSubCategory("Ноутбуки");

        YandexMarketSubCategoryPage subCategoryPage = new YandexMarketSubCategoryPage(driver);
        subCategoryPage.getProductByIndex(0).addToCompare();
        String firstProduct = subCategoryPage.getProductByIndex(0).getProductName();
        expectedProductNames.add(firstProduct);

        subCategoryPage.getProductByIndex(1).addToCompare();
        String secondProduct = subCategoryPage.getProductByIndex(1).getProductName();
        expectedProductNames.add(secondProduct);

        subCategoryPage.clickCompareButton();
        YandexMarketComparePage comparePage = PageFactory.initElements(driver, YandexMarketComparePage.class);
        List<String> actualProductNames = comparePage.getComparedProductNames();

        assertEqualsNoOrder(actualProductNames.toArray(), expectedProductNames.toArray());
    }

    @Test
    public void checkFilterTest() {
        YandexMarketHomePage homePage = new YandexMarketHomePage(driver);
        homePage.goToCategory("Бытовая техника");

        YandexMarketCategoryPage categoryPage = new YandexMarketCategoryPage(driver);
        categoryPage.goToSubCategory("Холодильники");

        YandexMarketSubCategoryPage subCategoryPage = new YandexMarketSubCategoryPage(driver);
        subCategoryPage.selectCheckbox("сверху");
        subCategoryPage.selectCheckbox("снизу");

        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        assertEqualsNoOrder(actualProductNames.toArray(), expectedProductNames.toArray());
//        assertThat(actualProductNames)
//                .describedAs("List does not match")
//                .containsExactlyInAnyOrderElementsOf(expectedProductNames);
    }
}
