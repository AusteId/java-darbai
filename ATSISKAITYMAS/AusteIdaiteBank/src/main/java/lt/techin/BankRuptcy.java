package lt.techin;

import lt.itakademija.exam.*;

import java.util.ArrayList;
import java.util.List;

public class BankRuptcy implements Bank {

    private CurrencyConverter currencyConverter;
    private List<Customer> customers = new ArrayList<>();
    private List<Account> accounts = new ArrayList<>();
    private SequenceGenerator idGeneratorForCustomer = new SequenceGenerator();
    private SequenceGenerator idGeneratorForAccount = new SequenceGenerator();

    public BankRuptcy(CurrencyConverter currencyConverter) {
        this.currencyConverter = currencyConverter;
    }

    @Override
    public Customer createCustomer(PersonCode personCode, PersonName personName) {

        if (personCode != null && personName != null) {
            if (customers.stream().anyMatch((a) -> a.getPersonCode().equals(personCode))) {
                throw new CustomerCreateException("Customer with such personCode already exist");
            } else {
                long id = this.idGeneratorForCustomer.getNext();
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
            if (!this.customers.contains(customer)) {
                throw new AccountCreateException("Customer does not belong to this bank");
            } else {
                long id = this.idGeneratorForAccount.getNext();
                Account customerAcc = new Account(id, customer, currency, this.getBalance(currency));
                customer.addAccount(customerAcc);
                this.accounts.add(customerAcc);
                return customerAcc;
            }
        } else {
            throw new NullPointerException();
        }
    }

    @Override
    public Operation transferMoney(Account account, Account account1, Money money) {
        return null;
    }

    @Override
    public Money getBalance(Currency currency) {
        return null;
    }
}
