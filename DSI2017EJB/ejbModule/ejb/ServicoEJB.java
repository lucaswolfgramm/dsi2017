package ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Servico;

/**
 * Session Bean implementation class ServicoEJB
 */
@Stateless
@LocalBean
public class ServicoEJB implements ServicoEJBLocal {

	/**
	 * Default constructor.
	 */
	@PersistenceContext(name = "dsi2017context")
	private EntityManager em;

	public ServicoEJB() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Servico> todosServicos() {
		Query q = em.createNamedQuery("todosServicos");
		return q.getResultList();
	}

	@Override
	public void save(Servico servico) {
		if (em.find(Servico.class, servico.getIdentificador()) == null) {
			// insert
			em.persist(servico);
		} else {
			// update
			em.merge(servico);
		}
	}

	@Override
	public void remove(Servico servico) {
		em.remove(em.find(Servico.class, servico.getIdentificador()));
	}
}
