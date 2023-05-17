package entities;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "persone")
@Getter
@Setter
@NoArgsConstructor

public class Persona {
	@Id
	@GeneratedValue
	private UUID id;
	private String nome;
	private String cognome;
	private String email;
	private LocalDate birthdate;
	private String sesso;

	@OneToMany(mappedBy = "persona", cascade = CascadeType.ALL)

	Set<Partecipazione> listaPartecipazioni;

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", email=" + email + ", birthdate="
				+ birthdate + ", sesso=" + sesso + ", listaPartecipazioni=" + listaPartecipazioni + "]";
	}

	public Persona(String nome, String cognome, String email, LocalDate birthdate, String sesso) {
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.birthdate = birthdate;
		this.sesso = sesso;
	}

}
