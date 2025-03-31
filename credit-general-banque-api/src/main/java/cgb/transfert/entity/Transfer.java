package cgb.transfert.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import lombok.*;

@Entity
@Data
public class Transfer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private String sourceAccountNumber;
    private String destinationAccountNumber;
    private Double amount;
    private LocalDate transferDate;
    private String description;
    private enum etat{success, failure, currents};
    private etat etatTransfert;

    @ManyToOne
    @JoinColumn(name = "lot_transfer_id")  // Ajoute cette colonne pour faire le lien
    private LotTransfer lotTransfer;
    // Getters and Setters with lombok
    
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSourceAccountNumber() {
		return sourceAccountNumber;
	}
	public void setSourceAccountNumber(String sourceAccountNumber) {
		this.sourceAccountNumber = sourceAccountNumber;
	}
	public String getDestinationAccountNumber() {
		return destinationAccountNumber;
	}
	public void setDestinationAccountNumber(String destinationAccountNumber) {
		this.destinationAccountNumber = destinationAccountNumber;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public LocalDate getTransferDate() {
		return transferDate;
	}
	public void setTransferDate(LocalDate transferDate) {
		this.transferDate = transferDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public etat getEtatTransfert() {
		return etatTransfert;
	}
	public void setEtatTransfert(etat etatTransfert) {
		this.etatTransfert = etatTransfert;
	}

}