package model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "incomes")
@ToString
public class Income {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate date;
    private double amount;

    @Column(name = "income_category_id")
    private int incomeCategory;

    @Column(name = "account_id")
    private int account;

    private String comment;
}