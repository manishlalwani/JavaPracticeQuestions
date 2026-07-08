package org.practice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.practice.questions.BankAccount;
import org.practice.util.InsufficientBalanceException;
import org.practice.util.InvalidValueException;

public class BankAccountTest {
    private BankAccount account;

    @BeforeEach
    void setUp() {
        account = new BankAccount(1000);
    }

    @Test
    public void shouldDepositAndWithdrawSuccessfully() {
        assertAll(
                () -> assertEquals("SUCCESS", account.depositAmount(1000L)),
                () -> assertEquals("SUCCESS", account.withdrawAmount(100L)),
                () -> assertEquals(1900L, account.getBalance()));
    }

    @Test
    public void shouldMultipleDepositsSuccessfully() {

        assertEquals("SUCCESS", account.depositAmount(1000));
        assertEquals("SUCCESS", account.depositAmount(200));
        assertEquals(2200L, account.getBalance());
    }

    @Test
    public void shouldWithdrawMultipleSuccessfully() {

        assertEquals("SUCCESS", account.withdrawAmount(100));
        assertEquals("SUCCESS", account.withdrawAmount(200));
        assertEquals(700L, account.getBalance());
    }

    @Test
    public void shouldDepositAndWithdrawFullBalanceSuccessfully() {

        account.depositAmount(1000L);
        account.withdrawAmount(2000L);
        assertEquals(0L, account.getBalance());
    }

    @Test
    public void shouldDepositAndWithdrawZeroSuccessfully() {

        account.depositAmount(1000L);
        account.withdrawAmount(0L);
        assertEquals(2000L, account.getBalance());
    }

    @Test
    public void shouldDepositZeroAndWithdrawSuccessfully() {

        account.depositAmount(0L);
        account.withdrawAmount(600L);
        assertEquals(400L, account.getBalance());
    }

    @Test
    public void shouldThrowExceptionForInsufficientBalance() {

        account.depositAmount(1000L);
        assertThrows(InsufficientBalanceException.class, () -> account.withdrawAmount(2100L));
        assertEquals(2000L, account.getBalance());

    }

    @Test
    public void shouldThrowExceptionForNegativeWithDrawal() {

        account.depositAmount(1000L);
        assertThrows(InvalidValueException.class, () -> account.withdrawAmount(-2100L));
        assertEquals(2000L, account.getBalance());
    }

    @Test
    public void shouldThrowExceptionForNegativeDeposit() {

        assertThrows(InvalidValueException.class, () -> account.depositAmount(-1000L));
        assertEquals(1000L, account.getBalance());
    }

    @Test
    public void shouldThrowExceptionForNegativeInitialBalance() {

        assertThrows(InvalidValueException.class, () -> new BankAccount(-1000L));
    }

    @Test
    public void shouldAllowZeroInitialBalance() {

        BankAccount user1 = new BankAccount(0L);
        assertEquals(0L, user1.getBalance());
    }

    @Test
    public void shouldHandleLargeTransactions() {
        BankAccount user1 = new BankAccount(1_000_000L);
        assertEquals("SUCCESS", user1.depositAmount(5_000_000L));
        assertEquals("SUCCESS", user1.withdrawAmount(2_000_000L));
        assertEquals(4_000_000L, user1.getBalance());
    }

    @Test
    void shouldThrowCorrectExceptionMessageForNegativeBalance() {

        InvalidValueException ex = assertThrows(
                InvalidValueException.class,
                () -> new BankAccount(-100L));

        assertEquals(
                "Balance Can't be less than 0",
                ex.getMessage());
    }
}
