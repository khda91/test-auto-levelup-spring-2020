package lesson.selenium.allure.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AssertionSteps extends AbstractBaseStep {

    public AssertionSteps(WebDriver driver) {
        super(driver);
    }

    @Step("Проверить что выбранные товары '{0}' добавлены к сравнению")
    public void assertThatAddedProductsAddedToComparing(List<String> expectedItems) {
        List<String> actualProductNames = yandexMarketComparePage.getComparedProductNames();
        assertThat(actualProductNames)
                .describedAs("List does not match")
                .containsExactlyInAnyOrderElementsOf(expectedItems);
    }
}
