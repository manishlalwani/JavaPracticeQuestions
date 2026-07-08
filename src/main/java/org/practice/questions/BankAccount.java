package org.practice.questions;

import org.practice.util.InsufficientBalanceException;
import org.practice.util.InvalidValueException;

public class BankAccount {
    private long balance;

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public BankAccount(long balance) {
        if (balance < 0)
            throw new InvalidValueException("Balance Can't be less than 0");
        else
            setBalance(balance);
    }

    public String depositAmount(long amount) {
        if (amount < 0)
            throw new InvalidValueException("Deposit Amount Can't be less than 0");
        else {
            this.balance = getBalance() + amount;
            return "SUCCESS";
        }
    }

    public String withdrawAmount(long amount) {
        if (amount < 0)
            throw new InvalidValueException("Withdraw Amount Can't be less than 0");
        else if (amount > 0 && amount > getBalance()) {
            throw new InsufficientBalanceException("Insufficient Balance");
        } else {
            this.balance = getBalance() - amount;
            return "SUCCESS";
        }
    }

}
