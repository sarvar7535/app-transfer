package pdp.uz.service;

import org.springframework.http.ResponseEntity;
import pdp.uz.dto.TransferDto;

import javax.servlet.http.HttpServletRequest;

public interface TransferService {

    ResponseEntity<?> transfer(TransferDto dto, HttpServletRequest request);

}
