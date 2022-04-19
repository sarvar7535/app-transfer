package pdp.uz.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "card")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "number", nullable = false)
    private String number;

    @Column(name = "balance")
    private Double balance;

    @Column(name = "expire_date", nullable = false)
    private Date expireDate;

    @Column(name = "active", nullable = false)
    private boolean active = true;
}
