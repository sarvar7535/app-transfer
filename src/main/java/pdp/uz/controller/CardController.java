package pdp.uz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pdp.uz.dto.CardDto;
import pdp.uz.service.CardService;


import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/card")
public class CardController {

    @Autowired
    CardService cardService;

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody CardDto dto, HttpServletRequest request) {
        return cardService.add(dto, request);
    }

    @GetMapping("/get")
    public ResponseEntity<?> get(HttpServletRequest request) {
        return cardService.get(request);
    }

}
