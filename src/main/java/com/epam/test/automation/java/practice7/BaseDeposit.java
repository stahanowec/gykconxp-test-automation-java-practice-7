package com.epam.test.automation.java.practice7;


import java.math.BigDecimal;
import java.math.RoundingMode;

public class BaseDeposit extends Deposit {

    private static final BigDecimal PERCENT = BigDecimal.valueOf(0.05);

    public BaseDeposit(BigDecimal amount, Integer period) {
        super(amount, period);
    }

    @Override
    BigDecimal income() {

        var income = amount;
        for (var i = 0; i < period; i++) {
            income = income.add(income.multiply(PERCENT));
        }
        return income.setScale(2, RoundingMode.DOWN);
    }

}
