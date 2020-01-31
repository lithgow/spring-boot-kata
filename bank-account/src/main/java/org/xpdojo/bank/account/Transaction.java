package org.xpdojo.bank.account;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.Objects;

import static org.xpdojo.bank.account.Transaction.Direction.CREDIT;
import static org.xpdojo.bank.account.Transaction.Direction.DEBIT;

public class Transaction {

    private final Money amount;
    private final Direction direction;
    private final LocalDateTime dateTime;

    public Transaction(@JsonProperty(value = "amount", required = true) Money amount,
                       @JsonProperty(value = "direction", required = true) Direction direction,
                       @JsonProperty(value = "dateTime", required = true) LocalDateTime dateTime) {
        this.amount = amount;
        this.direction = direction;
        this.dateTime = dateTime;
    }

    public static Transaction anOpeningBalanceOf(Money anAmount, LocalDateTime date) {
        return new Transaction(anAmount, CREDIT, date);
    }

    public static Transaction aDepositOf(Money anAmount, LocalDateTime date) {
        return new Transaction(anAmount, CREDIT, date);
    }

    public static Transaction aWithDrawlOf(Money anAmount, LocalDateTime date) {
        return new Transaction(anAmount, DEBIT, date);
    }

    Direction direction() {
        return direction;
    }

    Money amount() {
        return amount;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    Money balanceImpact() {
        if (direction == DEBIT)
            return amount.negative();
        else
            return amount;
    }

    public enum Direction {
        DEBIT, CREDIT
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Objects.equals(amount, that.amount) &&
                direction == that.direction &&
                Objects.equals(dateTime, that.dateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, direction, dateTime);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "amount=" + amount +
                ", direction=" + direction +
                ", dateTime=" + dateTime +
                '}';
    }
}
