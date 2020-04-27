package lesson.unit.tests.beforeafter;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorMultilplyTest extends AbstractBaseTest {

    @Test
    public void testMultiplyTPT() {
        System.out.println("Test testMultiplyTPT");
        Assert.assertEquals(calculator.multiply(2, 2), 4);
    }
}
