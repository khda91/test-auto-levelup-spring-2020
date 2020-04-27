package lesson.unit.tests.beforeafter;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorSumTest extends AbstractBaseTest {

    @Test
    public void testSumTPT() {
        System.out.println("Test testSumTPT");
        Assert.assertEquals(calculator.sum(2, 2), 4);
    }
}
