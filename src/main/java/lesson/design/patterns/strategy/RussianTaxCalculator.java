package lesson.design.patterns.strategy;

public class RussianTaxCalculator implements TaxCalculationStrategy {

    private static final double TAX_RATE = 0.13D;

    @Override
    public double calculateTax(double salary) {
        return salary * TAX_RATE;
    }
}
