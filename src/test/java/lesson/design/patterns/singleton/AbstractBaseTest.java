package lesson.design.patterns.singleton;

import io.qameta.allure.Step;
import lesson.selenium.allure.steps.ActionSteps;
import lesson.selenium.allure.steps.AssertionSteps;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class AbstractBaseTest {

    protected ActionSteps actionSteps;

    protected AssertionSteps assertionSteps;

    @BeforeMethod
    @Step("Открыть Яндеск Маркет")
    public void setUp() {
        WebDriverSingleton.INSTANCE.setDriver(WebDriverFactorySingleton.getInstance().createDriver("chrome"));
        WebDriverSingleton.INSTANCE.getDriver().get("https://market.yandex.ru/");

        actionSteps = new ActionSteps(WebDriverSingleton.INSTANCE.getDriver());
        assertionSteps = new AssertionSteps(WebDriverSingleton.INSTANCE.getDriver());
    }

    @AfterMethod
    public void tearDown() {

        WebDriverSingleton.INSTANCE.setDriver(null);
    }
}
