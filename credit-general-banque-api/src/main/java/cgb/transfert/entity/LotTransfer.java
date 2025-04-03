package cgb.transfert.entity;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import cgb.transfert.dto.Etat;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class LotTransfer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "lot_transfer_id") // Ajoute cette colonne pour faire le lien
	private List<Transfer> lotTransfer;
	private String refLot;
	private String sourceAccountNumber;
	private LocalDate date;

	private Etat etatLotTransfer;

	public LotTransfer() {
	}

	public LotTransfer(List<Transfer> lotTransfer, String refLot, String sourceAccountNumber,
			LocalDate date, Etat etatLotTransfer) {
		this.lotTransfer = lotTransfer;
		this.refLot = refLot;
		this.sourceAccountNumber = sourceAccountNumber;
		this.date = date;
		this.etatLotTransfer = etatLotTransfer;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Transfer> getLotTransfer() {
		return lotTransfer;
	}

	public void setLotTransfer(List<Transfer> lotTransfer) {
		this.lotTransfer = lotTransfer;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Etat getEtatLotTransfer() {
		return etatLotTransfer;
	}

	public void setEtatLotTransfer(Etat etatLotTransfer) {
		this.etatLotTransfer = etatLotTransfer;
	}

	public String getSourceAccountNumber() {
		return sourceAccountNumber;
	}

	public void setSourceAccountNumber(String sourceAccountNumber) {
		this.sourceAccountNumber = sourceAccountNumber;
	}

	public String getRefLot() {
		return refLot;
	}

	public void setRefLot(String refLot) {
		this.refLot = refLot;
	}

}
