package lt.techin;

import ibank.Account;
import ibank.Bank;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
import java.util.stream.Collectors;

import static java.math.BigDecimal.valueOf;


public class BankRuptcy implements Bank {

    private ArrayList<Account> accounts = new ArrayList<>();

    @Override
    public int getNumberOfAccounts() {
        return accounts.size();
    }

    @Override
    public BigDecimal getTotalReserves() {
        return accounts.stream().map(a -> a.getBalance()).reduce(BigDecimal.ZERO, (a, b) -> a.add(b));
    }

    @Override
    public Collection<Account> getAllAccounts() {

        ArrayList<Account> accountsNew = new ArrayList<>();
        for (Account acc : accounts) {
            accountsNew.add(acc);
        }
        return accountsNew;
    }

    @Override
    public Account openDebitAccount(String name) {

        if (getAccountByHolderName(name) == null) {
            String accountNumber = "100100100" + generateRandomNumber() + generateRandomNumber() + generateRandomNumber();
            Account newDebitAccount = new DebitAccount(accountNumber, name, BigDecimal.ZERO);
            accounts.add(newDebitAccount);
            return newDebitAccount;
        }
        return null;
    }

    @Override
    public Account openCreditAccount(String name, BigDecimal bigDecimal) {
        if (getAccountByHolderName(name) == null) {
            String accountNumber = "100100100" + generateRandomNumber() + generateRandomNumber() + generateRandomNumber();
            Account newCreditAccount = new CreditAccount(accountNumber, name, bigDecimal, BigDecimal.ZERO);
            accounts.add(newCreditAccount);
            return newCreditAccount;
        }
        return null;
    }

    @Override
    public Account getAccountByHolderName(String s) {
        return accounts.stream().filter(a -> a.getHolderName().contains(s)).findFirst().orElse(null);
    }

    @Override
    public Account getAccountByNumber(String s) {
        return accounts.stream().filter(a -> a.getNumber().contains(s)).findFirst().orElse(null);
    }

    @Override
    public void closeAccount(Account account) {
        accounts.remove(account);
    }

    public String generateRandomNumber() {
        Random random = new Random();
        int num = random.nextInt(10);
        return String.valueOf(num);
    }
}
