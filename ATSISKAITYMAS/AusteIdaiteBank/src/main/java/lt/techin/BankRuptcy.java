package lt.techin;

import lt.itakademija.exam.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BankRuptcy implements Bank {

    private CurrencyConverter currencyConverter;
    private List<Customer> customers = new ArrayList<>();
    private List<Account> accounts = new ArrayList<>();
    private SequenceGenerator idGeneratorForCustomer = new SequenceGenerator();
    private SequenceGenerator idGeneratorForAccount = new SequenceGenerator();
    private SequenceGenerator idGeneratorForTransaction = new SequenceGenerator();

    public BankRuptcy(CurrencyConverter currencyConverter) {
        this.currencyConverter = currencyConverter;
    }

    @Override
    public Customer createCustomer(PersonCode personCode, PersonName personName) {

        if (personCode != null && personName != null) {
            if (customers.stream().anyMatch((a) -> a.getPersonCode().equals(personCode))) {
                throw new CustomerCreateException("Customer with such personCode already exist");
            } else {
                long id = idGeneratorForCustomer.getNext();
                Customer customer = new Customer(id, personCode, personName);
                customers.add(customer);
                return customer;
            }
        } else {
            throw new NullPointerException();
        }
    }

    @Override
    public Account createAccount(Customer customer, Currency currency) {

        if (customer != null && currency != null) {
            if (!customers.contains(customer)) {
                throw new AccountCreateException("Customer does not belong to this bank");
            } else {
                long id = idGeneratorForAccount.getNext();
                Account customerAcc = new Account(id, customer, currency, getBalance(currency));
                customer.addAccount(customerAcc);
                accounts.add(customerAcc);
                return customerAcc;
            }
        } else {
            throw new NullPointerException();
        }
    }

    @Override
    public Operation transferMoney(Account debitAccount, Account creditAccount, Money debitAmount) {

        long id = idGeneratorForTransaction.getNext();
        Operation transfer = new Operation(id, debitAccount, creditAccount, debitAmount);
        if (debitAccount.getBalance() != null && !debitAccount.getBalance().isLessThan(debitAmount)) {
            if (debitAccount.getCurrency().equals(creditAccount.getCurrency())) {
                debitAccount.setBalance(getBalance(debitAccount.getCurrency()).substract(debitAmount));
                creditAccount.setBalance(getBalance(creditAccount.getCurrency()).add(debitAmount));
            }
            return transfer;
        } else {
            throw new InsufficientFundsException("Not enough money");
        }
    }

    @Override
    public Money getBalance(Currency currency) {

        Money totalAmountOfMoneyInBank = new Money(0);

        for (Account acc : accounts) {
            totalAmountOfMoneyInBank = totalAmountOfMoneyInBank.add(currencyConverter.convert(acc.getCurrency(), currency, acc.getBalance()));
        }

        return totalAmountOfMoneyInBank;
    }
}
