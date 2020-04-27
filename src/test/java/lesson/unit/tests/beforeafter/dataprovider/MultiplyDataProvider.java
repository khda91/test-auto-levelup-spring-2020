package lesson.unit.tests.beforeafter.dataprovider;

import org.testng.annotations.DataProvider;

public class MultiplyDataProvider {

    @DataProvider(name = "Multiply Positive Data Provider")
    public Object[][] multiplyPositiveData() {
        return new Object[][] {
                {2, 2, 4},
                {3, 3, 9},
                {4, 4, 16},
                {5, 5, 25}
        };
    }

    @DataProvider
    public Object[][] multiplyNegativeData() {
        return new Object[][] {
                {2, 2, 5},
                {3, 3, 6},
                {4, 4, 7},
                {5, 5, 8}
        };
    }
}
