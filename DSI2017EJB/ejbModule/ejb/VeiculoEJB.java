package ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Veiculo;

/**
 * Session Bean implementation class VeiculoEJB
 */
@Stateless
@LocalBean
public class VeiculoEJB implements VeiculoEJBLocal {

	/**
	 * Default constructor.
	 */
	@PersistenceContext(name = "dsi2017context")
	private EntityManager em;

	public VeiculoEJB() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Veiculo> todosVeiculos() {
		Query q = em.createNamedQuery("todosVeiculos");
		return q.getResultList();
	}

	@Override
	public void save(Veiculo veiculo) {
		if (em.find(Veiculo.class, veiculo.getOid()) == null) {
			// insert
			em.persist(veiculo);
		} else {
			// update
			em.merge(veiculo);
		}
	}

	@Override
	public void remove(Veiculo veiculo) {
		em.remove(em.find(Veiculo.class, veiculo.getIdentificador()));
	}
}
