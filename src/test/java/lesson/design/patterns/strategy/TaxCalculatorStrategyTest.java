package lesson.design.patterns.strategy;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TaxCalculatorStrategyTest {

    @DataProvider
    public Object[][] taxStrategyDataProvider() {
        return new Object[][] {
                {new RussianTaxCalculator(), 50000},
                {new UsTaxCalculator(), 20000},
                {new UsTaxCalculator(), 20000.00001},
                {new UsTaxCalculator(), 35000},
                {new UsTaxCalculator(), 50000.0000001},
                {new UsTaxCalculator(), 75000}

        };
    }

    @Test(dataProvider = "taxStrategyDataProvider")
    public void taxStrategyTest(TaxCalculationStrategy calculationStrategy, double salary) {
        TaxCalculatorProvider provider = new TaxCalculatorProviderImpl(calculationStrategy);
        System.out.println(provider.calculateTax(salary));
    }
}
