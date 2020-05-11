package lesson.selenium.core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.By.className;
import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElementsLocatedBy;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertEqualsNoOrder;

public class YandexMarketLocatorExtendTest {

    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://market.yandex.ru/");
    }

    @Test
    public void compareMobilePhoneTest() {
        WebDriverWait wait = new WebDriverWait(driver, 10, 1000);

        wait.until(elementToBeClickable(linkText("Компьютеры"))).click();
        wait.until(elementToBeClickable(linkText("Ноутбуки"))).click();

        WebElement pageTitle = wait.until(visibilityOfElementLocated(cssSelector("[title='Ноутбуки']")));

        assertEquals(pageTitle.getText(), "Ноутбуки");

        List<WebElement> products = driver.findElements(cssSelector("div.n-snippet-card2"));

        List<String> expectedProductName = new ArrayList<>();

        new Actions(driver)
                .moveToElement(products.get(0).findElement(cssSelector("div.n-product-toolbar__item")))
                .click()
                .build()
                .perform();
        expectedProductName.add(products.get(0).findElement(className("n-snippet-card2__title")).getText());

        new Actions(driver)
                .moveToElement(products.get(1).findElement(cssSelector("div.n-product-toolbar__item")))
                .click()
                .build()
                .perform();
        expectedProductName.add(products.get(1).findElement(className("n-snippet-card2__title")).getText());

        wait.until(elementToBeClickable(linkText("Сравнить"))).click();

        List<WebElement> actualProductNames = wait.until(visibilityOfAllElementsLocatedBy(className("n-compare-head__name")));

//        List<String> actualCollectedProductNames = new ArrayList<>();
//        for (WebElement actualProductName : actualProductNames) {
//            actualCollectedProductNames.add(actualProductName.getText());
//        }
//        assertEqualsNoOrder(actualCollectedProductNames.toArray(), expectedProductName.toArray());

//        assertEqualsNoOrder(actualProductNames
//                .stream()
//                .map(WebElement::getText).toArray(), expectedProductName.toArray());

        assertThat(actualProductNames)
                .extracting(WebElement::getText)
                .containsExactlyInAnyOrderElementsOf(expectedProductName);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
