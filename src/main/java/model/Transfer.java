package model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "transfers")
public class Transfer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate date;
    private double amount;

    @Column(name = "source_account_id")
    private int sourceAccountId;

    @Column(name = "destination_account_id")
    private int destinationAccountId;

    private String comment;
}