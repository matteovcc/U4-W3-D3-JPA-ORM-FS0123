package dao;

import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entities.Locations;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LocationDAO {
	private final EntityManager em;

	public LocationDAO(EntityManager em) {
		this.em = em;
	}

	public void saveLocation(Locations l) {
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.persist(l);
		t.commit();
		log.info("Location aggiunta !");
	}

	public Locations getLocationById(String id) {
		Locations found = em.find(Locations.class, UUID.fromString(id));
		return found;
	}
}