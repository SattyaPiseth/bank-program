package co.istad.bank.model;

import lombok.*;

/**
 * @author Sattya
 * create at 5/4/2024 12:06 AM
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreditCard extends Account{
    private Double limit;
}
