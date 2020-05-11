package lesson.selenium.page.objects1;

import lesson.selenium.page.AbstractBaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class YandexMarketSimplePageObjectTest extends AbstractBaseTest {

    @Test
    public void simpleTest() {
        String actual = new YandexMarketHomePage(driver)
                .goToElectronicPage()
                .goToMobilePhonePage()
                .getFirstPhoneName();
        System.out.println(actual);
        assertEquals(actual, "Смартфон iPhone 7 32GB");
    }

    @Test
    public void searchTest() {
        String actual = new YandexMarketHomePage(driver)
                .searchItem("iphone 7")
                .getPhoneName();
        System.out.println(actual);
        assertEquals(actual, "Смартфон iPhone 7 128GB");
    }
}
