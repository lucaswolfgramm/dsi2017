package ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Fornecedor;
import model.Oficina;

/**
 * Session Bean implementation class OficinaEJB
 */
@Stateless
@LocalBean
public class OficinaEJB implements OficinaEJBLocal {

	/**
	 * Default constructor.
	 */
	@PersistenceContext(name = "dsi2017context")
	private EntityManager em;

	public OficinaEJB() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Oficina> todasOficinas() {
		Query q = em.createNamedQuery("todasOficinas");
		return q.getResultList();
	}

	@Override
	public void save(Oficina oficina) {
		if (em.find(Oficina.class, oficina.getOid()) == null) {
			// insert
			em.persist(oficina);
		} else {
			// update
			em.merge(oficina);
		}
	}

	@Override
	public void remove(Oficina oficina) {
		em.remove(em.find(Oficina.class, oficina.getIdentificador()));
	}
}
