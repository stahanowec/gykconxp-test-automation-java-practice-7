package com.epam.test.automation.java.practice7;


import java.math.BigDecimal;

public abstract class Deposit {

    protected BigDecimal amount;
    protected Integer period;

    protected Deposit(BigDecimal amount, Integer period) {
        this.amount = amount;
        this.period = period;
    }

    abstract BigDecimal income();
 }
