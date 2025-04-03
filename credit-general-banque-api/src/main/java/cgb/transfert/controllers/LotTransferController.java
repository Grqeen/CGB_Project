package cgb.transfert.controllers;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.net.httpserver.Authenticator.Success;

import cgb.transfert.entity.Account;
import cgb.transfert.entity.LotTransfer;
import cgb.transfert.entity.Transfer;
import cgb.transfert.entity.TransferRequest;
import cgb.transfert.services.LotTransferService;
import cgb.transfert.services.TransferService;
import cgb.transfert.dto.LotTransferDTO;
import cgb.transfert.entity.*;

@RestController
@RequestMapping("/lotTransfer")
public class LotTransferController {
	@Autowired
	private LotTransferService lottransferService;


	@PostMapping("/createLotTransfer")
    public ResponseEntity<?> saveLotTransfer(@RequestBody LotTransferDTO dto) {
        LotTransfer saved = lottransferService.saveLotTransfer(dto);
        return ResponseEntity.ok(saved);
    }

//	@GetMapping("/findAll/LotTransfer")
//	public ResponseEntity<?> findAllLotTransfer() {
//		List<LotTransfer> transferLot = lottransferService.findAllLotTransfer();
//		return ResponseEntity.ok(transferLot);
//	}

}

class LotTransferResponse {

	private String status;
	private String message;

	public LotTransferResponse(String status, String message) {
		this.status = status;
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}