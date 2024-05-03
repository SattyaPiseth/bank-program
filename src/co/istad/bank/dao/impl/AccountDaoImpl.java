package co.istad.bank.dao.impl;

import co.istad.bank.dao.AccountDao;
import co.istad.bank.datasource.AccountDataSource;
import co.istad.bank.model.SavingAccount;

import java.util.Optional;

/**
 * @author Sattya
 * create at 5/4/2024 12:40 AM
 */
public class AccountDaoImpl implements AccountDao {
    @Override
    public Optional<SavingAccount> findByActNo(String actNo) {
     Optional<SavingAccount> account = AccountDataSource.accounts.stream()
                .filter(act->act.getActNo().equals(actNo))
                .map(act->{
                    SavingAccount savingAccount = (SavingAccount) act;
                    System.out.println(savingAccount.getInterestRate());
                    return savingAccount;
                })
                .findFirst();
        return account;
    }
}
