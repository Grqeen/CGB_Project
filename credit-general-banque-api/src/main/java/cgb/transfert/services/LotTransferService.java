package cgb.transfert.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import cgb.transfert.entity.Account;
import cgb.transfert.entity.LotTransfer;
import cgb.transfert.entity.Transfer;
import cgb.transfert.repository.AccountRepository;
import cgb.transfert.repository.LotTransferRepository;
import cgb.transfert.repository.TransferRepository;
import jakarta.transaction.Transactional;

@Service
public class LotTransferService {

	@Autowired
	private LotTransferRepository transferRepository;

	public LotTransfer saveLotTransfer(LotTransfer lottransfer) {
		return transferRepository.save(lottransfer);
	}
	
	@GetMapping
	public List<LotTransfer> findAllLotTransfer() {
		return transferRepository.findAll();
	}
}
