package com.epam.test.automation.java.practice7;

import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.testng.AssertJUnit.assertEquals;

public class SpecialDepositTest {
    @Test
    public void ifCalculateIncomeThenSuccess() {
        //given
        var specialDeposit = new SpecialDeposit(new BigDecimal(1000), 2);
        var expected = BigDecimal.valueOf(30.20).setScale(2, RoundingMode.FLOOR);
        //when
        var income = specialDeposit.income();
        //then
        assertEquals(expected, income);

    }
}