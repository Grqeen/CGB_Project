package cgb.transfert.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cgb.transfert.entity.Log;
import cgb.transfert.entity.LotTransfer;
import cgb.transfert.entity.Transfer;
import cgb.transfert.repository.LotTransferRepository;
import cgb.transfert.repository.TransferRepository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class LotMapperDTO {

    @Autowired
    private LotTransferRepository lotRepository;

    @Autowired
    private TransferRepository transferRepository;

    public static LotTransfer toEntity(LotTransferDTO dto) {
        LotTransfer lotTransfer = new LotTransfer();

   
        lotTransfer.setRefLot(dto.getRefLot());
        lotTransfer.setEtatLotTransfer(Etat.WAITING);
        lotTransfer.setSourceAccountNumber(dto.getSourceAccountNumber());
        lotTransfer.setDate(LocalDate.now());

        if (dto.getLotTransfers() != null) {
        	new Log(Etat.SUCESS, "Lot transfers non null", LocalDate.now());
            List<Transfer> transfers = new ArrayList<>();
            for (TransferDTO transferDTO : dto.getLotTransfers()) {            
                Transfer transfer = new Transfer();
                transfer.setSourceAccountNumber(dto.getSourceAccountNumber());
                transfer.setDestinationAccountNumber(transferDTO.getDestinationAccountNumber());
                transfer.setAmount(transferDTO.getAmount());
                transfer.setTransferDate(transferDTO.getTransferDate());
                transfer.setDescription(transferDTO.getDescription());
                transfer.setTransferDate(LocalDate.now());

                transfers.add(transfer);
            }
            lotTransfer.setLotTransfer(transfers);
        }

        return lotTransfer;
    }


}
