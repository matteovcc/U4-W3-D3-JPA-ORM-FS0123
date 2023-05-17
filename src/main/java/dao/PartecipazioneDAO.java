package dao;

import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entities.Partecipazione;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PartecipazioneDAO {
	private final EntityManager em;

	public PartecipazioneDAO(EntityManager em) {
		this.em = em;
	}

	public void savePartecipazione(Partecipazione p) {
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.persist(p);
		t.commit();
		log.info("Persona aggiunta !");
	}

	public Partecipazione getPersonaById(String id) {
		Partecipazione found = em.find(Partecipazione.class, UUID.fromString(id));
		return found;
	}
}
