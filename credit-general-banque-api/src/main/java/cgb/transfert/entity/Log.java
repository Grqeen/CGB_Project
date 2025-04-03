package cgb.transfert.entity;

import java.time.LocalDate;

import cgb.transfert.dto.Etat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Log {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Etat etatlog;
	private String description;
	private LocalDate date;
	
	public Log(Etat etatlog, String description, LocalDate date) {
		this.etatlog = etatlog;
		this.description = description;
		this.date = date;
	}

	public Etat getEtatlog() {
		return etatlog;
	}

	public void setEtatlog(Etat etatlog) {
		this.etatlog = etatlog;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	
}
