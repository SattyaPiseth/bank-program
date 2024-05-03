package co.istad.bank.datasource;

import co.istad.bank.model.Account;
import co.istad.bank.model.CreditCard;
import co.istad.bank.model.SavingAccount;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sattya
 * create at 5/4/2024 12:08 AM
 */
public class AccountDataSource {
    public static List<Account> accounts;

    public static void init(){
        accounts = new ArrayList<>();

        // Create Saving Account
        Account account1 = new  SavingAccount(10.0);
        account1.setId(1);
        account1.setActName("ACCOUNT_01");
        account1.setActNo("ACT01");
        account1.setBalance(1000.0);
        account1.setPin(1234);

        // Create credit card account
        Account account2 = new CreditCard(1000.0);
        account2.setId(2);
        account2.setActName("ACCOUNT_02");
        account2.setActNo("ACT02");
        account2.setBalance(1000.0);
        account2.setPin(9999);

        accounts.addAll(List.of(account1,account2));
    }
}
