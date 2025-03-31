package cgb.transfert.entity;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class LotTransfer {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToMany(mappedBy = "lotTransfer", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private List<Transfer> lotTransfer;

	private String description;
	private Date date;

	public enum etat {
		success, waiting , failure, canceled
	}

	private etat etatLotTransfer;

	public LotTransfer() {}
	public LotTransfer(List<Transfer> lotTransfer, String description, Date date, etat etatLotTransfer) {

		this.lotTransfer = lotTransfer;
		this.description = description;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public etat getEtatLotTransfer() {
		return etatLotTransfer;
	}

	public void setEtatLotTransfer(etat etatLotTransfer) {
		this.etatLotTransfer = etatLotTransfer;
	}

}
