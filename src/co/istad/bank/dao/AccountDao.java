package co.istad.bank.dao;

import co.istad.bank.model.SavingAccount;

import java.util.Optional;

/**
 * @author Sattya
 * create at 5/4/2024 12:40 AM
 */
public interface AccountDao {
    Optional<SavingAccount> findByActNo(String actNo);

}
