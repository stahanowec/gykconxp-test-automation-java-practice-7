package com.epam.test.automation.java.practice7;

import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.testng.AssertJUnit.assertEquals;

public class LongDepositTest {
    @Test
    public void ifCalculateIncomeThenSuccess() {
        //given
        var longDeposit = new LongDeposit(new BigDecimal(1000), 7);
        var expected = BigDecimal.valueOf(1150.00).setScale(2, RoundingMode.CEILING);
        //when
        var income = longDeposit.income();
        //then
        assertEquals(expected, income);

    }
}