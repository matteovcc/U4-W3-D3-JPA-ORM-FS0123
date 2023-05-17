package dao;

import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entities.Persona;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PersonaDAO {
	private final EntityManager em;

	public PersonaDAO(EntityManager em) {
		this.em = em;
	}

	public void savePersona(Persona p) {
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.persist(p);
		t.commit();
		log.info("Persona aggiunta !");
	}

	public Persona getPersonaById(String id) {
		Persona found = em.find(Persona.class, UUID.fromString(id));
		return found;
	}
}
