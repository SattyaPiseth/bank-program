package co.istad.bank.dao.impl;

import co.istad.bank.dao.TransactionDao;
import co.istad.bank.model.Account;
import co.istad.bank.model.SavingAccount;

/**
 * @author Sattya
 * create at 5/3/2024 11:59 PM
 */
public class TransactionDaoImpl implements TransactionDao {

    @Override
    public void deposit(Double amount, Account account) {
        if (amount <= 0){
             System.out.println("Amount should be greater than 0");
            return;
        }
        account.setBalance(account.getBalance() + amount);
    }

    @Override
    public void withdrawal(Double amount, Account account) {
        if (amount <= 0){
            System.out.println("Amount should be greater than 0");
            return;
        } else if (account.getBalance() < amount) {
            System.out.println("Insufficient balance");
            return;
        }
        account.setBalance(account.getBalance() - amount);
    }

    @Override
    public void checkBalance(Account account) {
        SavingAccount savingAccount = (SavingAccount) account;
        System.out.println("Act No: " + savingAccount.getActNo());
        System.out.println("Act Name: " +savingAccount.getActName());
        System.out.println("Balance: " + savingAccount.getBalance());
        System.out.println("Interest Rate: " + savingAccount.getInterestRate());
    }
}
