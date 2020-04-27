package lesson.unit.tests.beforeafter;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorSubstractTest extends AbstractBaseTest {

    @Test
    public void testSubstractTMT() {
        System.out.println("Test testSubstractTMT");
        Assert.assertEquals(calculator.substract(2, 2), 0);
    }
}
