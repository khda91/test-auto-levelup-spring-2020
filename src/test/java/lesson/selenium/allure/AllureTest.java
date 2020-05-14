package lesson.selenium.allure;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

@Test(description = "Яндекс Маркет. Сравнение")
public class AllureTest extends AbstractBaseTest {

    @Test(description = "Добавление товаров к ставнению")
    @Description("Проверка товаров на добавление в сравнение")
    @Issue("KHDA-999")
    @TmsLink("KHDA-99")
    @Link("KHDA-9")
    public void compareProductsPageObjectTest() {
        List<String> expectedProduct = new ArrayList<>();
        actionSteps.navigateToCategory("Компьютеры");
        actionSteps.navigateToSubCategory("Ноутбуки");
        String firstProduct = actionSteps.addProductToCompare(0);
        expectedProduct.add(firstProduct);
        String secondProduct = actionSteps.addProductToCompare(1);
        expectedProduct.add(secondProduct);
        actionSteps.compareSelectedProducts();
        assertionSteps.assertThatAddedProductsAddedToComparing(expectedProduct);
    }
}
