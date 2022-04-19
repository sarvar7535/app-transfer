package pdp.uz.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pdp.uz.domain.Card;
import pdp.uz.helpers.Utils;
import pdp.uz.repository.CardRepo;
import pdp.uz.repository.IncomeRepo;
import pdp.uz.service.IncomeService;


import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Service
public class IncomeServiceImpl implements IncomeService {

    @Autowired
    IncomeRepo incomeRepo;
    @Autowired
    CardRepo cardRepo;

    @Override
    public ResponseEntity<?> get(Long id, HttpServletRequest request) {
        String username = Utils.getUsername(request);
        Optional<Card> optionalCard = cardRepo.findByUsernameAndIdAndActiveTrue(username, id);
        if (!optionalCard.isPresent()) {
            return ResponseEntity.status(404).body("Card not found");
        }
        return ResponseEntity.ok(incomeRepo.findAllByFromCardId(id));
    }
}
