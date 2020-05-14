package lesson.selenium.page.elements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

public class ImplisitVsExplicitWaitsTest {

    protected WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://market.yandex.ru/");
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void compareProductsPageObjectTest() {
        YandexMarketHomePage homePage = new YandexMarketHomePage(driver);
        homePage.goToCategory("Компьютеры");

        YandexMarketCategoryPage categoryPage = new YandexMarketCategoryPage(driver);
        categoryPage.goToSubCategory("Ноутбуки");

        YandexMarketSubCategoryPage subCategoryPage = new YandexMarketSubCategoryPage(driver);

        long startTime = System.currentTimeMillis();
        boolean sortedLinksVisible = subCategoryPage.isSortedLinksVisible();
        long endTime = System.currentTimeMillis();

        System.out.println("Time: " + ((double) (endTime - startTime) / 1000) );

        assertThat(sortedLinksVisible)
                .describedAs("sorted list does not visible")
                .isTrue();
    }
}
