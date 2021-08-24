package com.epam.test.automation.java.practice7;


import java.math.BigDecimal;
import java.math.RoundingMode;

public class LongDeposit extends Deposit{

    private static final BigDecimal PERCENT =  BigDecimal.valueOf(0.15);

    public LongDeposit(BigDecimal amount, Integer period) {
        super(amount, period);
    }

    @Override
    BigDecimal income() {
        var income = amount;
        for (var i = 6; i < period; i++) {
            income = income.add(income.multiply(PERCENT).setScale(2, RoundingMode.HALF_EVEN));
        }
        income = income.subtract(amount);
        return income;
    }
}
