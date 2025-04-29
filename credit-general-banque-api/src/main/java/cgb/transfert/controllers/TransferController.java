package cgb.transfert.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import cgb.transfert.Etat;
import cgb.transfert.entity.Account;
import cgb.transfert.entity.Log;
import cgb.transfert.entity.Transfer;
import cgb.transfert.entity.TransferRequest;
import cgb.transfert.repository.LogRepository;
import cgb.transfert.services.LotTransferService;
import cgb.transfert.services.TransferService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/transfers")
public class TransferController {

    @Autowired
    private TransferService transferService;

    @Autowired
    private LotTransferService lottransferService;
    
    @Autowired
	private LogRepository logRepository;

    @PostMapping("/creerTransfer/")
    public ResponseEntity<?> createTransfer(@RequestBody TransferRequest transferRequest) {
    //public ResponseEntity<Transfer> createTransfer(@RequestBody TransferRequest transferRequest) {
    	try {
    	Transfer transfer = transferService.createTransfer(
                transferRequest.getSourceAccountNumber(),
                transferRequest.getDestinationAccountNumber(),
                transferRequest.getAmount(),
                transferRequest.getTransferDate(),
                transferRequest.getDescription()
        );
		Log logger = new Log(Etat.SUCCESS, "transfer reussie", LocalDate.now(), this.getClass().getSimpleName());
		logRepository.save(logger);
    	return ResponseEntity.ok(transfer);
        }catch (RuntimeException e) {
            TransferResponse errorResponse = new TransferResponse("FAILURE", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
        
    }  
    
    

    @GetMapping("/findAll")
    public ResponseEntity<?> findAllAccount(){
    	List<Account> account = transferService.findAllAccount();
    	return ResponseEntity.ok(account);
    }
    
    @GetMapping("/findAllTransfer")
    public ResponseEntity<?> findAllTransfer(){
    	List<Transfer> transfer = transferService.findAllAccountTransfer();
    	return ResponseEntity.ok(transfer);
    }
    
    /*
    @PostMapping
    public ResponseEntity<String> testTransfer(@RequestBody String s) {
    	System.out.println("Post reçu");
        return ResponseEntity.ok("Post bien traité: "+ s);
    } 
    */
    
}


class TransferResponse {
    private String status;
    private String message;

    // Constructeur
    public TransferResponse(String status, String message) {
        this.status = status;
        this.message = message;
    }

    // Getters et Setters
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
