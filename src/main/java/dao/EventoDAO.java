package dao;

import java.sql.Connection;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entities.Evento;

public class EventoDAO {
	// QUA DENTRO AVREMO PURE BISOGNO DELL'ENTITY MANAGER OLTRE CHE AI METODI , LO
	// CREERO NEL MAIN E LO PASSERO AI MIEI DAO
	private final EntityManager em;
	static Connection conn = null;

	public EventoDAO(EntityManager em) {
		this.em = em;
	}

	public void save(Evento e) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.persist(e);
		transaction.commit(); // esecuzione del flash (invio dal persistence context al db)
	}

	public Evento getById(String id) {
		Evento found = em.find(Evento.class, UUID.fromString(id)); // il primo parametro sarà la classe di
																	// pertinenza(Nomeclasse.class),
		// il secondo sarà l'id;
		if (found != null) {
			System.out.println("Evento" + " " + id + " " + "trovato");
		} else {
			System.out.println("Non abbiamo trovato niente");
		}
		return found;

	}
//PRIMO TENTATIVO
//	public void delete(long id, LocalDate date) {
//		Evento found = em.find(Evento.class, date);
//		if (found != null) {
//			EntityTransaction transaction = em.getTransaction();
//			transaction.begin();
//			em.remove(found);
//			transaction.commit();
//			System.out.println("Evento in data: " + date + " " + "è stato eliminato dal db");
//		} else {
//			System.out.println("non ho eliminato un bel  niente");
//		}
//	}

	public void delete(long id) {
		Evento found = em.find(Evento.class, id);
		if (found != null) {
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			em.remove(found);
			transaction.commit();
			System.out.println("Evento " + id + " " + "è stato eliminato dal db");
		} else {
			System.out.println("non ho eliminato un bel  niente");
		}
	}

	public void refresh(long id) {
		Evento found = em.find(Evento.class, id);
		if (found != null) {

			found.setNumeroMassimoPartecipanti(120);
			System.out.println("Pre refresh");
			System.out.println(found);
			em.refresh(found);
			System.out.println("Post refresh");
			System.out.println(found);
		} else {
			System.out.println("non ho trovato niente e non ho refreshato");
		}
	}
//SECONDO TENTATIVO
//	public void deleteByTitle(String titolo) {
//		Query q = em.createNativeQuery("SELECT * FROM eventi WHERE titolo = ?");
////		try {
////			PreparedStatement stmtDelete = conn.prepareStatement(q);
////			stmtDelete.setString(1, titolo);
////			stmtDelete.execute();
////			System.out.println("Evento eliminato by Titolo");
////		} catch (SQLException e) {
////			e.printStackTrace();
////		}
//		q.setParameter("titolo", titolo);
//		List<Evento> resultList = q.getResultList();
//		EntityTransaction transaction = em.getTransaction();
//		transaction.begin();
//		for (Evento eventoSingolo : resultList) {
//			em.remove(eventoSingolo);
//		}
//		transaction.commit();
//		System.out.println("L'evento" + " " + titolo + " " + "è stato eliminato");
//		if (resultList.isEmpty()) {
//			System.out.println("Non c'è nessun evento con questo titolo");
//		}
//	}

	// TERZO TENTATIVO
//	public void deleteByTitolo(String titolo) {
//		Query q = em.createNativeQuery("SELECT * FROM eventi WHERE titolo = ?");
//		q.setParameter(1, titolo);
//		List<Evento> resultList = q.getResultList();
//		if (!resultList.isEmpty()) {
//			EntityTransaction transaction = em.getTransaction();
//			transaction.begin();
//			for (Evento evento : resultList) {
//				em.remove(evento);
//			}
//			transaction.commit();
//			System.out.println("L'evento"  + titolo +  "sono stati eliminati dal db");
//		} else {
//			System.out.println("Non esistono eventi con questo titolo");
//		}
//	}

	// QUARTO TENTATIVO

//	public void deleteByTitle(String titolo) {
//		Query q = em.createNativeQuery("DELETE eventi WHERE titolo IN (:ex)");
//		q.setParameter("ex", titolo).executeUpdate();
//
//	}
	// QUINTO TENTATIVO
//	public void deleteByTitle(String titolo) {
//		Query q = em.createNativeQuery("SELECT * FROM  eventi WHERE titolo = ?");
//		q.setParameter(1, titolo);
//		EntityTransaction transaction = em.getTransaction();
//		transaction.begin();
//		List<Evento> rl = q.getResultList();
//		for (Evento eventi : rl) {
//			em.remove(eventi);
//
//		}
//		transaction.commit();
//
//	}

}
