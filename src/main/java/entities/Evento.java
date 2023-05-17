package entities;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "eventi")
@Getter
@Setter

public class Evento {
	@Id
	@GeneratedValue
	private UUID id;
	private String titolo;
	private LocalDate date;
	private String descrizione;
	private String tipoEvento;
	private int numeroMassimoPartecipanti;

	@OneToMany(mappedBy = "evento", cascade = CascadeType.ALL)
	private Set<Partecipazione> partecipanti;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "location_id", referencedColumnName = "id")
	private Locations location;

	public Evento(String titolo, LocalDate date, String descrizione, String tipoEvento, int numeroMassimoPartecipanti) {
		super();
		this.titolo = titolo;
		this.date = date;
		this.descrizione = descrizione;
		this.tipoEvento = tipoEvento;
		this.setNumeroMassimoPartecipanti(numeroMassimoPartecipanti);
	}

	public Evento() {

	}

	@Override
	public String toString() {
		return "Evento [id=" + id + ", titolo=" + titolo + ", date=" + date + ", descrizione=" + descrizione
				+ ", tipoEvento=" + tipoEvento + ", numeroMassimoPartecipanti=" + numeroMassimoPartecipanti + "]";
	}

	public Evento(String titolo, LocalDate date, String descrizione, String tipoEvento, int numeroMassimoPartecipanti,
			Set<Partecipazione> partecipanti, Locations location) {
		super();
		this.titolo = titolo;
		this.date = date;
		this.descrizione = descrizione;
		this.tipoEvento = tipoEvento;
		this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
		this.partecipanti = partecipanti;
		this.location = location;
	}

	public Evento(String titolo, LocalDate date, String descrizione, String tipoEvento, int numeroMassimoPartecipanti,
			Locations location) {
		super();
		this.titolo = titolo;
		this.date = date;
		this.descrizione = descrizione;
		this.tipoEvento = tipoEvento;
		this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
		this.location = location;
	}

//	public int getNumeroMassimoPartecipanti() {
//		return numeroMassimoPartecipanti;
//	}
//
//	public void setNumeroMassimoPartecipanti(int numeroMassimoPartecipanti) {
//		this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
//	}

//	@Override
//	public String toString() {
//		return titolo + " " + descrizione + " " + "in data" + " " + date + " " + "Num Partecipanti" + " "
//				+ numeroMassimoPartecipanti;
//	}

}
