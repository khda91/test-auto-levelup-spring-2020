package lesson.design.patterns.strategy;

public class TaxCalculatorProviderImpl implements TaxCalculatorProvider {

    private TaxCalculationStrategy strategy;

    public TaxCalculatorProviderImpl(TaxCalculationStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public double calculateTax(double salary) {
        return strategy.calculateTax(salary);
    }
}
