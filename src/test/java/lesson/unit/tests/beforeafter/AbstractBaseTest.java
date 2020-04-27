package lesson.unit.tests.beforeafter;

import lesson.unit.tests.Calculator;
import org.testng.annotations.*;

public abstract class AbstractBaseTest {

    protected Calculator calculator;

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
