package com.epam.test.automation.java.practice7;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.testng.AssertJUnit.assertEquals;

public class ClientTest {
    private Client client;

    @BeforeMethod
    public void init(){
        this.client = new Client();
        this.client.addDeposit(new BaseDeposit(new BigDecimal(1000), 3));
        this.client.addDeposit( new LongDeposit(new BigDecimal(1000), 7));
        this.client.addDeposit(new SpecialDeposit(new BigDecimal(1000), 2));
    }

    @Test
    public void ifTotalIncomeThenSuccess() {
        //given
        var expected =  BigDecimal.valueOf(3337.82).setScale(2, RoundingMode.FLOOR);
        //when
        var totalIncome= client.totalIncome();
        //then
        assertEquals(expected, totalIncome);
    }

    @Test
    public void ifMaxIncomeThenSuccess() {
        //given
        var expected = BigDecimal.valueOf(1157.62).setScale(2, RoundingMode.CEILING);
        //when
        var totalIncome= client.maxIncome();
        //then
        assertEquals(expected, totalIncome);
    }

}
