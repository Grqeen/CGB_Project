package cgb.transfert.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import cgb.transfert.dto.Etat;
import cgb.transfert.dto.LotMapperDTO;
import cgb.transfert.dto.LotTransferDTO;
import cgb.transfert.entity.Account;
import cgb.transfert.entity.Log;
import cgb.transfert.entity.LotTransfer;
import cgb.transfert.entity.Transfer;
import cgb.transfert.repository.AccountRepository;
import cgb.transfert.repository.LogRepository;
import cgb.transfert.repository.LotTransferRepository;
import cgb.transfert.repository.TransferRepository;
import jakarta.transaction.Transactional;

@Service
public class LotTransferService {

	@Autowired
	private TransferService transferService;
	
	@Autowired
	private LotTransferRepository transferRepository;
	
	@Autowired
	private LotMapperDTO lotMapperDTO;

	@Autowired
	private LogRepository logRepository;
    

	public LotTransfer saveLotTransfer(LotTransferDTO dto) {
		Log logger = new Log(Etat.FAILURE, "Probleme lors du save du lot", LocalDate.now(), this.getClass().getSimpleName());

		LotTransfer lotTransfer = lotMapperDTO.toEntity(dto);
		for(Transfer u : lotTransfer.getLotTransfer()) {
			transferService.createLotTransfer(u.getSourceAccountNumber() , u.getDestinationAccountNumber(), u.getAmount(), u.getTransferDate(), u.getDescription());
		}

		if( transferRepository.save(lotTransfer) != null) {
			logger = new Log(Etat.SUCCESS, "Save effectué sur le lotTransfer", LocalDate.now(), this.getClass().getSimpleName());

		}
		
		logRepository.save(logger);
		
		;
		return lotTransfer;
	}

//	@GetMapping
//	public List<LotTransfer> findAllLotTransfer() {
//		return transferRepository.findAll();
//	}
}
