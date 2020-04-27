package lesson.unit.tests.beforeafter;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class CalculatorSumDataProviderTest extends AbstractBaseTest {

    @BeforeTest
    public void setUpTest() {
        System.out.println("Before Test");
    }

    @DataProvider
    public Object[][] sumPositiveDataProvider() {
        return new Object[][]{
                {2, 2, 4},
                {3, 3, 6},
                {5, 6, 11},
                {8, 8, 16}
        };
    }

    @Test(dataProvider = "sumPositiveDataProvider")
    public void testSumTPT(int a, int b, int expected) {
        System.out.println("Test testSumTPT: " + a + " + " + b + " = " + expected);
        assertEquals(calculator.sum(a, b), expected);
    }

    @DataProvider(name = "Negative Sum Test Data")
    public Object[][] sumNegativeDataProvider() {
        return new Object[][]{
                {2, 2, 5},
                {3, 3, 5},
                {5, 6, 5},
                {8, 8, 5}
        };
    }

    @Test(dataProvider = "Negative Sum Test Data")
    public void testNegativeSumTPT(int a, int b, int expected) {
        System.out.println("Test testNegativeSumTPT: " + a + " + " + b + " = " + expected);
        assertNotEquals(calculator.sum(a, b), expected);
    }

    @AfterTest
    public void tearDownTest() {
        System.out.println("After test");
    }
}
