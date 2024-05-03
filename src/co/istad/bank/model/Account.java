package co.istad.bank.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Sattya
 * create at 5/4/2024 12:01 AM
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Account {
    private Integer id;
    private String actName;
    private String actNo;
    private Double balance;
    private Integer pin;
}
