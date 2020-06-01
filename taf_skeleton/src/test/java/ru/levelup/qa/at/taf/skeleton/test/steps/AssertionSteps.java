package ru.levelup.qa.at.taf.skeleton.test.steps;

import io.qameta.allure.Step;
import ru.levelup.qa.at.taf.skeleton.services.pages.YandexMarketComparePage;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AssertionSteps extends AbstractBaseStep {

    private static AssertionSteps instance;

    private AssertionSteps() {
    }

    @Step("Проверить что выбранные товары '{0}' добавлены к сравнению")
    public void assertThatAddedProductsAddedToComparing(List<String> expectedItems) {
        List<String> actualProductNames = YandexMarketComparePage.getInstance().getComparedProductNames();
        assertThat(actualProductNames)
                .describedAs("List does not match")
                .containsExactlyInAnyOrderElementsOf(expectedItems);
    }

    public static AssertionSteps assertionSteps() {
        if (instance == null) {
            instance = new AssertionSteps();
        }
        return instance;
    }
}
