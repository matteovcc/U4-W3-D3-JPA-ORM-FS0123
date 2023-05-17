package entities;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "locations")
@Getter
@Setter
@NoArgsConstructor
public class Locations {
	@Id
	@GeneratedValue
	private UUID id;
	private String nomeLocation;
	private String citta;

	public Locations(String nomeLocation, String citta) {

		this.nomeLocation = nomeLocation;
		this.citta = citta;
	}

	@Override
	public String toString() {
		return "Location [id=" + id + ", nomeLocation=" + nomeLocation + ", citta=" + citta + "]";
	}

}
