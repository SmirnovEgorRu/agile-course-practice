package ru.unn.agile.StatisticsCalculation.model;

public class MomentOrderChecker {
    public static void checkOrder(final Integer order) {
        checkNullOrder(order);
        checkNegativeOrder(order);
    }

    private static void checkNegativeOrder(final Integer order) {
        if (order <= 0) {
            throw new IllegalArgumentException("Raw moment order should be more than 0");
        }
    }

    private static void checkNullOrder(final Integer order) {
        if (order == null) {
            throw new IllegalArgumentException("Raw moment order should not be null!");
        }
    }

    private MomentOrderChecker() { }
}
