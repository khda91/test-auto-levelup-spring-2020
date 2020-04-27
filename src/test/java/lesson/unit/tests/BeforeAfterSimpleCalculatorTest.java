package lesson.unit.tests;

import org.testng.Assert;
import org.testng.annotations.*;

public class BeforeAfterSimpleCalculatorTest {

    private Calculator calculator;

    @BeforeSuite
    public void setUpSuite() {
        System.out.println("Before suite");
    }

    @BeforeClass
    public void setUpClass() {
        System.out.println("Before class");
    }

    @BeforeMethod
    public void setUpMethod() {
        System.out.println("Before method");
        calculator = new Calculator();
    }

    @Test
    public void testSumTPT() {
        System.out.println("Test testSumTPT");
        Assert.assertEquals(calculator.sum(2, 2), 4);
    }

    @Test
    public void testMultiplyTPT() {
        System.out.println("Test testMultiplyTPT");
        Assert.assertEquals(calculator.multiply(2, 2), 4);
    }

    @AfterMethod
    public void tearDownMethod() {
        System.out.println("After method");
        calculator = null;
    }

    @AfterClass
    public void tearDownClass() {
        System.out.println("After class");
    }

    @AfterSuite
    public void tearDownSuite() {
        System.out.println("After suite");
    }
}
