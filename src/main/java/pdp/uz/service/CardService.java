package pdp.uz.service;

import org.springframework.http.ResponseEntity;
import pdp.uz.dto.CardDto;

import javax.servlet.http.HttpServletRequest;

public interface CardService {

    ResponseEntity<?> add(CardDto dto, HttpServletRequest request);

    ResponseEntity<?> get(HttpServletRequest request);
}
