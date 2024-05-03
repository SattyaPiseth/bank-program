package co.istad.bank.dao;

import co.istad.bank.model.Account;

/**
 * @author Sattya
 * create at 5/3/2024 11:58 PM
 */
public interface TransactionDao {
    void deposit(Double amount, Account account);
    void withdrawal(Double amount, Account account);
    void checkBalance(Account account);
}
