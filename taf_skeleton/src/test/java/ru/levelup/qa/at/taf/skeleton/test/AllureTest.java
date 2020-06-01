package ru.levelup.qa.at.taf.skeleton.test;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.levelup.qa.at.taf.skeleton.test.data.AllureTestDataProvider;

import java.util.ArrayList;
import java.util.List;

import static ru.levelup.qa.at.taf.skeleton.test.steps.ActionSteps.actionSteps;
import static ru.levelup.qa.at.taf.skeleton.test.steps.AssertionSteps.assertionSteps;

@Test(description = "Яндекс Маркет. Сравнение")
@Listeners({AllureStepListener.class})
public class AllureTest extends AbstractBaseTest {

    @Test(description = "Добавление товаров к ставнению",
            dataProviderClass = AllureTestDataProvider.class,
            dataProvider = "Compare project categories data provider")
    @Description("Проверка товаров на добавление в сравнение")
    @Issue("KHDA-999")
    @TmsLink("KHDA-99")
    @Link("KHDA-9")
    public void compareProductsPageObjectTest(String category, String subCategory) {
        List<String> expectedProduct = new ArrayList<>();
        actionSteps().navigateToCategory(category);
        actionSteps().navigateToSubCategory(subCategory);
        String firstProduct = actionSteps().addProductToCompare(0);
        expectedProduct.add(firstProduct);
        String secondProduct = actionSteps().addProductToCompare(1);
        expectedProduct.add(secondProduct);
        actionSteps().compareSelectedProducts();
        assertionSteps().assertThatAddedProductsAddedToComparing(expectedProduct);
    }
}
