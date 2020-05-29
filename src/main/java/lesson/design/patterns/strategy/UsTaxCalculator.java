package lesson.design.patterns.strategy;

public class UsTaxCalculator implements TaxCalculationStrategy {

    private static final double TAX_RATE_INCOME_LESS_20000 = 0.1D;
    private static final double TAX_RATE_INCOME_MORE_20000_AND_LESS_50000 = 0.2D;
    private static final double TAX_RATE_INCOME_MORE_50000 = 0.35D;

    private static final double LOW_INCOME = 20000.00D;
    private static final double HIGH_INCOME = 50000.00D;

    @Override
    public double calculateTax(double salary) {
        double tax = 0D;
        if (salary <= LOW_INCOME) {
            tax = salary * TAX_RATE_INCOME_LESS_20000;
        } else if (salary > LOW_INCOME && salary <= HIGH_INCOME) {
            tax = (salary * TAX_RATE_INCOME_MORE_20000_AND_LESS_50000) + (salary * 0.05D);
        } else {
            tax = (salary * TAX_RATE_INCOME_MORE_50000);
        }
        return tax;
    }
}
