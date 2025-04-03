package cgb.transfert.dto;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class LotTransferDTO {
    private String refLot;
    private String sourceAccountNumber;
    private LocalDate date;
    private String etatLotTransfer;
    private List<TransferDTO> lotTransfers;

    // Constructeur par défaut
    public LotTransferDTO() {
    }

    public LotTransferDTO(String refLot, String sourceAccountNumber, LocalDate date, String etatLotTransfer, List<TransferDTO> lotTransfers) {
        this.refLot = refLot;
        this.sourceAccountNumber = sourceAccountNumber;
        this.date = date;
        this.etatLotTransfer = etatLotTransfer;
        this.lotTransfers = lotTransfers;
    }

    public String getRefLot() {
        return refLot;
    }

    public void setRefLot(String refLot) {
        this.refLot = refLot;
    }

    public String getSourceAccountNumber() {
        return sourceAccountNumber;
    }

    public void setSourceAccountNumber(String sourceAccountNumber) {
        this.sourceAccountNumber = sourceAccountNumber;
    }

    public List<TransferDTO> getLotTransfers() { // ⬅ Retourne une liste de TransferDTO
        return lotTransfers;
    }

    public void setLotTransfers(List<TransferDTO> lotTransfers) { // ⬅ Accepte une liste de TransferDTO
        this.lotTransfers = lotTransfers;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getEtatLotTransfer() {
        return etatLotTransfer;
    }

    public void setEtatLotTransfer(String etatLotTransfer) {
        this.etatLotTransfer = etatLotTransfer;
    }
}
