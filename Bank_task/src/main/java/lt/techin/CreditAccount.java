package lt.techin;

import ibank.Account;

import java.math.BigDecimal;

public class CreditAccount implements Account {

    private String number;
    private String name;
    private BigDecimal creditLimit;
    private BigDecimal balance = BigDecimal.ZERO;

    public CreditAccount(String number, String name, BigDecimal creditLimit, BigDecimal balance) {
        this.number = number;
        this.name = name;
        this.creditLimit = creditLimit;
        this.balance = balance;
    }

    @Override
    public String getNumber() {
        return number;
    }

    @Override
    public String getHolderName() {
        return name;
    }

    @Override
    public BigDecimal getBalance() {
        return balance;
    }

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    @Override
    public boolean deposit(BigDecimal bigDecimal) {
        BigDecimal initialBalance = balance;
        balance = balance.add(bigDecimal);
        return initialBalance.add(bigDecimal).compareTo(balance) == 0;
    }

    @Override
    public boolean withdraw(BigDecimal amount) {
        BigDecimal initialBalance = balance;
        BigDecimal initialLimit = creditLimit;
        if ((balance.add(creditLimit)).compareTo(amount) >= 0) {
//            BigDecimal whatsLeft = balance.subtract(amount);
//            creditLimit.subtract(whatsLeft);
            balance = balance.subtract(amount);
            return true;
        }
        // return (initialBalance.add(initialLimit)).compareTo(balance.add(creditLimit).add(amount)) == 0;
        return false;
    }
}


