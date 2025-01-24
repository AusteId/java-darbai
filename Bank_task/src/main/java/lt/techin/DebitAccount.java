package lt.techin;

import ibank.Account;

import java.math.BigDecimal;
import java.util.Random;

public class DebitAccount implements Account {

    private String number;
    private String name;
    private BigDecimal balance = BigDecimal.ZERO;

    public DebitAccount(String number, String name, BigDecimal balance) {
        this.number = number;
        this.name = name;
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

    @Override
    public boolean deposit(BigDecimal bigDecimal) {
        BigDecimal initialBalance = balance;
        balance = balance.add(bigDecimal);
        return initialBalance.add(bigDecimal).compareTo(balance) == 0 ;
    }

    @Override
    public boolean withdraw(BigDecimal bigDecimal) {
        BigDecimal initialBalance = balance;
        if(balance.compareTo(bigDecimal) >= 0) {
            balance = balance.subtract(bigDecimal);
        }
        return balance.compareTo(initialBalance.subtract(bigDecimal)) == 0;
    }

}
