package lesson.unit.tests.beforeafter;

import lesson.unit.tests.beforeafter.dataprovider.MultiplyDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotEquals;

public class CalculatorMultiplyDataProviderTest extends AbstractBaseTest {

    @Test(dataProviderClass = MultiplyDataProvider.class, dataProvider = "Multiply Positive Data Provider")
    public void testPositiveMultiply(int a, int b, int expected) {
        System.out.println("Test testMultiply: " + a + " + " + b + " = " + expected);
        Assert.assertEquals(calculator.multiply(a, b), expected);
    }

    @Test(dataProviderClass = MultiplyDataProvider.class, dataProvider = "multiplyNegativeData")
    public void testNegativeMultiply(int a, int b, int expected) {
        System.out.println("Test testNegativeMultiply: " + a + " + " + b + " = " + expected);
        assertNotEquals(calculator.multiply(a, b), expected);
    }
}
