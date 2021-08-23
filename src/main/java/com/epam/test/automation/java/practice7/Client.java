package com.epam.test.automation.java.practice7;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.stream.IntStream;

public class Client {

    private Deposit[] deposits;

    public Client() {
        this.deposits = new Deposit[10];
    }

    public boolean addDeposit(Deposit deposit) {
        var pairStream = IntStream.range(0, deposits.length)
                .filter(element -> deposits[element] == null)
                .findFirst();

        if (pairStream.isPresent()) {
            this.deposits[pairStream.getAsInt()] = deposit;
            return true;
        }
        return false;
    }

    public BigDecimal totalIncome() {
        return Arrays.stream(deposits).filter(Objects::nonNull).map(Deposit::income).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal maxIncome() {
        return Arrays.stream(deposits)
                .filter(Objects::nonNull)
                .map(Deposit::income)
                .max(Comparator.naturalOrder())
                .stream()
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public BigDecimal getIncomeByNumber(int index) {
        var deposit = deposits[index];
        if (null == deposit) {
            return BigDecimal.ZERO;
        }
        return deposit.income();
    }
}
