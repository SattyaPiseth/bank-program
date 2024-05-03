package co.istad.bank.model;

import lombok.*;

/**
 * @author Sattya
 * create at 5/4/2024 12:04 AM
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class SavingAccount extends Account{
    private Double interestRate;
}
