package lesson.unit.tests.soft.assertion;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertEquals;

public class SoftAssertionTest {

    // 2 + 5 * 4 - (10 + 2) = 10
    // 1. 5 * 4 == 20
    // 2. 10 + 2 == 12
    // 3. 2 + 20 == 22
    // 4. 22 - 12 == 10
    @Test
    public void test() {
        SoftAssert sa = new SoftAssert();
        int a = 5 * 5;
        sa.assertEquals(a, 20);
        int b = 10 + 2;
        sa.assertEquals(b, 12);
        int c = 2 + a;
        sa.assertEquals(c, 22);
        int d = c - b;
        sa.assertEquals(d, 10);
        sa.assertAll();
    }

    @Test
    public void test1() {
        int a = 5 * 4;
        assertEquals(a, 20);
        int b = 10 + 2;
        assertEquals(b, 12);
        int c = 12 + a;
        assertEquals(c, 22);
        int d = c - b;
        assertEquals(d, 10);
    }


}
