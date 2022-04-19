package pdp.uz.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pdp.uz.domain.Card;
import pdp.uz.dto.CardDto;
import pdp.uz.helpers.Utils;
import pdp.uz.repository.CardRepo;
import pdp.uz.service.CardService;


import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    CardRepo cardRepo;


    @Override
    public ResponseEntity<?> add(CardDto dto, HttpServletRequest request) {
        Card card = new Card();
        card.setBalance(dto.getBalance());
        card.setExpireDate(new Date(System.currentTimeMillis() + (518400000 * 60L)));
        card.setNumber(dto.getNumber());
        card.setUsername(Utils.getUsername(request));
        cardRepo.save(card);
        return ResponseEntity.ok(dto);
    }

    @Override
    public ResponseEntity<?> get(HttpServletRequest request) {
        String username = Utils.getUsername(request);
        List<Card> cardList = cardRepo.findAllByUsername(username);
        if (cardList.isEmpty()) {
            return ResponseEntity.status(404).body("Card not found");
        }
        return ResponseEntity.ok(cardList);
    }
}
