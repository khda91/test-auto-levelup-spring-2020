package lesson.selenium.page.objects2;

import lesson.selenium.page.AbstractBaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class YandexMarketSimplePageObjectTest extends AbstractBaseTest {

    @Test
    public void simpleTest() {
        String actual = new YandexMarketHomePage(driver)
                .goToCategory("Электроника")
                .goToSubCategory("Мобильные телефоны")
                .getFirstPhoneName();
        System.out.println(actual);
        assertEquals(actual, "Смартфон iPhone 7 32GB");
    }
}
