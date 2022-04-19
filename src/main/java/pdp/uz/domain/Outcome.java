package pdp.uz.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "outcome")
public class Outcome {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne(optional = false)
    @JoinColumn(name = "form_card_id")
    private Card fromCard;


    @ManyToOne(optional = false)
    @JoinColumn(name = "to_card_id")
    private Card toCard;


    @Column(name = "amount", nullable = false)
    private Double amount;


    @Column(columnDefinition = "timestamp default now()")
    private Timestamp date = Timestamp.valueOf(LocalDateTime.now());


    @Column(name = "commission_amount", nullable = false)
    private Double commissionAmount;
}
