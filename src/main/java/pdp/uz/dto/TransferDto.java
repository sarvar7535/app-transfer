package pdp.uz.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TransferDto {

    private Long fromCardId;

    private Long toCardId;

    private Double amount;

}
