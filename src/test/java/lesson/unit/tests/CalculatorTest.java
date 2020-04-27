package lesson.unit.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorTest {

    @Test
    public void sumTwoPlusTwoTest() {
        Calculator calculator = new Calculator();
        int actual = calculator.sum(2, 2);
        Assert.assertEquals(actual, 4);
    }
}
