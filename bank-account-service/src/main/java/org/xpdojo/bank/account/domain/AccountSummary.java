package org.xpdojo.bank.account.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.xpdojo.bank.account.Account;
import org.xpdojo.bank.account.Money;

import java.util.Objects;

public class AccountSummary {

    private final Long accountNumber;
    private final String description;
    private final Money overdraftFacility;
    private final Money balance;

    public AccountSummary(final Account account) {
        accountNumber = account.getAccountNumber();
        description = account.getDescription();
        overdraftFacility = account.getOverdraftFacility();
        balance = account.balance();
    }

    public AccountSummary(@JsonProperty("accountNumber") final Long accountNumber,
                          @JsonProperty("description")final String description,
                          @JsonProperty("overdraftFacility")final Money overdraftFacility,
                          @JsonProperty("balance")final Money balance) {
        this.accountNumber = accountNumber;
        this.description = description;
        this.overdraftFacility = overdraftFacility;
        this.balance = balance;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public String getDescription() {
        return description;
    }

    public Money getOverdraftFacility() {
        return overdraftFacility;
    }

    public Money getBalance() {
        return balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountSummary that = (AccountSummary) o;
        return Objects.equals(accountNumber, that.accountNumber) &&
                Objects.equals(description, that.description) &&
                Objects.equals(overdraftFacility, that.overdraftFacility) &&
                Objects.equals(balance, that.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber, description, overdraftFacility, balance);
    }

    @Override
    public String toString() {
        return "AccountSummary{" +
                "accountNumber=" + accountNumber +
                ", description='" + description + '\'' +
                ", overdraftFacility=" + overdraftFacility +
                ", balance=" + balance +
                '}';
    }
}
