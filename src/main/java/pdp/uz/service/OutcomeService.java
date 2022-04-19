package pdp.uz.service;

import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;

public interface OutcomeService {

    ResponseEntity<?> get(Long id, HttpServletRequest request);
}
