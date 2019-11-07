package ru.unn.agile.mortgagecalculator.Model;

import org.junit.Test;
import ru.unn.agile.mortgagecalculator.model.MortgageCalculator;

import static org.junit.Assert.*;

public class MortgageCalculatorTest {

    private final double delta = 0.001;

    @Test
    public void canCalculateForOneYearWithoutPayments() {
        MortgageCalculator calculator = new MortgageCalculator();

        double finalAmount = calculator.calculateWithoutPayments(50000, 10, 1);

        assertEquals(55000, finalAmount, delta);
    }

    @Test
    public void canCalculateForTwoYearsWithoutPayments() {
        MortgageCalculator calculator = new MortgageCalculator();

        double finalAmount = calculator.calculateWithoutPayments(50000, 10, 2);

        assertEquals(60500, finalAmount, delta);
    }

}
