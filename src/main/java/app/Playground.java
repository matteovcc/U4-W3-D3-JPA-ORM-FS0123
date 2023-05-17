package app;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import dao.EventoDAO;
import dao.LocationDAO;
import dao.PartecipazioneDAO;
import dao.PersonaDAO;
import entities.Evento;
import entities.Locations;
import entities.Partecipazione;
import entities.Persona;
import lombok.extern.slf4j.Slf4j;
import util.JpaUtil;

@Slf4j
public class Playground {
	private static EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
	private static final EntityManager em = null;

	public static void main(String[] args) {
		EntityManager em = emf.createEntityManager();
		EventoDAO ed = new EventoDAO(em);
		LocationDAO ld = new LocationDAO(em);
		PartecipazioneDAO pd = new PartecipazioneDAO(em);
		PersonaDAO prsd = new PersonaDAO(em);

//		Evento e1 = new Evento("Festa di compleanno", LocalDate.now(), "18esimo compleanno", "Privato", 150);
//		ed.save(e1);
//		log.info(e1.toString());

		Locations l1 = new Locations("Villa ponzi", "Roma");
//		ld.saveLocation(l1);
//		log.info(l1.toString());

		Locations found = ld.getLocationById("81bb72a6-1a80-4b5d-a359-35c03e656057");
		if (found != null) {
			log.info(found.toString());
		}

//		Evento e2 = new Evento("Festival", LocalDate.now(), "festival musica", "Pubblico", 2000, found);

		Evento eventoProva = new Evento();
//		ed.save(eventoProva);
		eventoProva.setLocation(found);

		Evento foundEvento = ed.getById("f42fc1f1-cc3f-4b2e-a371-a97db3305d4a");
		if (foundEvento != null) {
			log.info(foundEvento.toString());
		}

		Persona matteo = new Persona("Matteo", "Vacca", "mtvc@gmail.com", LocalDate.of(1999, 11, 04), "M");
//		prsd.savePersona(matteo);

		Persona foundPersona = prsd.getPersonaById("72675357-6ec4-4a24-914b-d092f943e227");
		if (foundPersona != null) {
			log.info(foundPersona.toString());
		}

		Set<Partecipazione> partecipazioni = new HashSet<>();

		Partecipazione p1 = new Partecipazione(matteo, foundEvento, "Confermato");
//		pd.savePartecipazione(p1);
		Partecipazione foundPartecipazione = pd.getPersonaById("63e8635b-45fa-4890-b317-457b559e7535");
		if (foundPartecipazione != null) {
			log.info(foundPartecipazione.toString());
		}

		eventoProva.setPartecipanti(foundPartecipazione);

		// Evento eventofinale = new Evento("Festival", LocalDate.now(), "Festival
		// musicale", "Pubblico", 2340, found);
//		ed.save(eventofinale);
//		eventofinale.getPartecipanti().add(foundPartecipazione);

	}

}
