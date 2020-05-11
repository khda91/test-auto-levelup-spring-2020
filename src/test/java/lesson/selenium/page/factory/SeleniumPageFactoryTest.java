package lesson.selenium.page.factory;

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

        String firstProduct = new YandexMarketHomePage(driver)
                .goToCategory("Компьютеры")
                .goToSubCategory("Ноутбуки")
                .addToCompareByIndex(0)
                .getProductNameByIndex(0);
        expectedProductNames.add(firstProduct);

        String secondProduct = new YandexMarketSubCategoryPage(driver)
                .addToCompareByIndex(1)
                .getProductNameByIndex(1);
        expectedProductNames.add(secondProduct);

        new YandexMarketSubCategoryPage(driver).clickCompareButton();

        YandexMarketComparePage comparePage = PageFactory.initElements(driver, YandexMarketComparePage.class);
        List<String> actualProductNames = comparePage.getComparedProductNames();

        assertEqualsNoOrder(actualProductNames.toArray(), expectedProductNames.toArray());
    }
}
