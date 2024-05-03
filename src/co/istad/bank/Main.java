package co.istad.bank;

import co.istad.bank.dao.AccountDao;
import co.istad.bank.dao.TransactionDao;
import co.istad.bank.dao.impl.AccountDaoImpl;
import co.istad.bank.dao.impl.TransactionDaoImpl;
import co.istad.bank.datasource.AccountDataSource;
import co.istad.bank.model.SavingAccount;

import java.util.Optional;
import java.util.Scanner;

/**
 * @author Sattya
 * create at 5/4/2024 12:10 AM
 */

public class Main {
    private final Scanner scanner;
    private final AccountDao accountDao;
    private final TransactionDao transactionDao;
    public Main(){
        this.accountDao = new AccountDaoImpl();
        this.scanner = new Scanner(System.in);
        this.transactionDao = new TransactionDaoImpl();
    }

    public static void main(String[] args) {
       Main main = new Main();
        // Initialize the account data source
        AccountDataSource.init();
       do {
           main.runProgram();
       }while (true);

    }
    private void deposit(){
        System.out.println("Start Deposit");
        System.out.print("Enter account number: ");
        String actNo = scanner.nextLine();
        Optional<SavingAccount> opSavingAccount = accountDao.findByActNo(actNo);
        if(opSavingAccount.isPresent()){
            SavingAccount savingAccount = opSavingAccount.get();

            System.out.print("Enter account pin : ");
            Integer pin = Integer.parseInt(scanner.nextLine());

            if (savingAccount.getPin().equals(pin)){
                System.out.print("Enter amount to deposit: ");
                Double amount = Double.parseDouble(scanner.nextLine());
                transactionDao.deposit(amount, savingAccount);
            }else {
                System.err.println("Invalid pin..!");
            }
        } else {
            System.err.println("Account NO doesn't exist");
        }

    }
    public void withdrawal(){
        System.out.println("Start Withdrawal");
        System.out.print("Enter account number: ");
        String actNo = scanner.nextLine();
        Optional<SavingAccount> opSavingAccount = accountDao.findByActNo(actNo);
        if(opSavingAccount.isPresent()){
            SavingAccount savingAccount = opSavingAccount.get();

            System.out.print("Enter account pin : ");
            Integer pin = Integer.parseInt(scanner.nextLine());

            if (savingAccount.getPin().equals(pin)){
                System.out.print("Enter amount to withdrawal: ");
                Double amount = Double.parseDouble(scanner.nextLine());
                transactionDao.withdrawal(amount, savingAccount);
            }else {
                System.err.println("Invalid pin..!");
            }
        } else {
            System.err.println("Account NO doesn't exist");
        }
    }

    private void runProgram(){

        System.out.println("Welcome to Bank Program");
        System.out.println("""
                Please choose one of the following options:
                1. Deposit
                2. Withdrawal
                3. Check Balance
                4. Exit
                """);
        System.out.print("Choose an option: ");
        int option = Integer.parseInt(scanner.nextLine());

        switch (option){
            case 1 ->{
                deposit();
            }
            case 2 ->{
                withdrawal();
            }
            case 3 ->{
                checkBalance();
            }
            case 4 ->{
               System.exit(0);
            }
        }
    }

    private void checkBalance(){
        System.out.println("Start Check Balance");

        System.out.print("Enter account number: ");
        String actNo = scanner.nextLine();

        Optional<SavingAccount> opSavingAccount = accountDao.findByActNo(actNo);

        if(opSavingAccount.isPresent()){
            SavingAccount savingAccount = opSavingAccount.get();

            System.out.print("Enter account pin : ");
            Integer pin = Integer.parseInt(scanner.nextLine());

            if (savingAccount.getPin().equals(pin)){
                transactionDao.checkBalance(savingAccount);
            }else {
                System.err.println("Invalid pin..!");
            }
        }
    }

}
