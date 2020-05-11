package lesson.selenium.page.voids;

import lesson.selenium.page.AbstractBaseTest;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

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
        subCategoryPage.addToCompareByIndex(0);
        String firstProduct = subCategoryPage.getProductNameByIndex(0);
        expectedProductNames.add(firstProduct);

        subCategoryPage.addToCompareByIndex(1);
        String secondProduct = subCategoryPage.getProductNameByIndex(1);
        expectedProductNames.add(secondProduct);

        subCategoryPage.clickCompareButton();
        YandexMarketComparePage comparePage = PageFactory.initElements(driver, YandexMarketComparePage.class);
        List<String> actualProductNames = comparePage.getComparedProductNames();

        assertEqualsNoOrder(actualProductNames.toArray(), expectedProductNames.toArray());
    }
}
