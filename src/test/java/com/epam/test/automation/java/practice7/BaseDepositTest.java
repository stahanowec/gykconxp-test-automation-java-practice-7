package com.epam.test.automation.java.practice7;

import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.testng.AssertJUnit.assertEquals;

public class BaseDepositTest {
    @Test
    public void ifCalculateIncomeThenSuccess() {
        //given
        var baseDeposit = new BaseDeposit(new BigDecimal(1000), 3);
        var expected =  BigDecimal.valueOf(1157.62).setScale(2, RoundingMode.CEILING);
        //when
        var income = baseDeposit.income();
        //then
        assertEquals(expected, income);

    }
}