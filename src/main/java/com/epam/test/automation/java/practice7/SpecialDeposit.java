package com.epam.test.automation.java.practice7;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SpecialDeposit extends Deposit {

    private static final BigDecimal PERCENT = BigDecimal.valueOf(0.01);

    public SpecialDeposit(BigDecimal amount, Integer period) {
        super(amount, period);
    }

    @Override
    BigDecimal income() {
        var income = amount;
        var incomePercent = PERCENT;
        for (var i = 0; i < period; i++) {
            income = income.add(income.multiply(incomePercent));
            incomePercent = incomePercent.add(PERCENT);
        }
        return income.setScale(2, RoundingMode.DOWN);
    }
}
