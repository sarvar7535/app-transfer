package pdp.uz.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pdp.uz.domain.Card;
import pdp.uz.domain.Income;
import pdp.uz.domain.Outcome;
import pdp.uz.dto.TransferDto;
import pdp.uz.helpers.Utils;
import pdp.uz.repository.CardRepo;
import pdp.uz.repository.IncomeRepo;
import pdp.uz.repository.OutcomeRepo;
import pdp.uz.service.TransferService;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Service
public class TransferServiceImpl implements TransferService {

    @Autowired
    IncomeRepo incomeRepo;
    @Autowired
    OutcomeRepo outcomeRepo;
    @Autowired
    CardRepo cardRepo;

    @Override
    public ResponseEntity<?> transfer(TransferDto dto, HttpServletRequest request) {
        String username = Utils.getUsername(request);
        Optional<Card> fromOptionalCard = cardRepo.findByUsernameAndIdAndActiveTrue(username, dto.getFromCardId());
        if (!fromOptionalCard.isPresent()) {
            return ResponseEntity.status(404).body("Card not found");
        }
        Optional<Card> toOptionalCard = cardRepo.findByIdAndActiveTrue(dto.getToCardId());
        if (!toOptionalCard.isPresent()) {
            return ResponseEntity.status(404).body("Card not found");
        }

        Card fromCard = fromOptionalCard.get();
        Card toCard = toOptionalCard.get();
        Double amount = dto.getAmount();
        if (amount > fromCard.getBalance()) {
            ResponseEntity.status(409).body("You don't have enough funds in your account");
        }
        Double commissionAndAmount = (amount * 1.0);
        fromCard.setBalance((fromCard.getBalance() - commissionAndAmount));
        toCard.setBalance((toCard.getBalance() + amount));

        cardRepo.save(fromCard);
        cardRepo.save(toCard);

        Income income = new Income();
        income.setAmount(amount);
        income.setFromCard(fromCard);
        income.setToCard(toCard);
        incomeRepo.save(income);

        Outcome outcome = new Outcome();
        outcome.setAmount(amount);
        outcome.setFromCard(fromCard);
        outcome.setToCard(toCard);
        outcome.setCommissionAmount(commissionAndAmount);
        outcomeRepo.save(outcome);

        return ResponseEntity.ok("Successfully");
    }
}
