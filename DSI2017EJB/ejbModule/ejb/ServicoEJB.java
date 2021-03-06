package ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Servico;

/**
 * Session Bean implementation class ServicoEJB
 */
@Stateless
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
		if (em.find(Servico.class, servico.getOid()) == null) {
			// insert
			em.persist(servico);
		} else {
			// update
			em.merge(servico);
		}
	}

	@Override
	public void remove(Servico servico) {
		em.remove(em.find(Servico.class, servico.getOid()));
	}

	@Override
	public List<Servico> todosServicos(String busca) {
		Query q = em.createNamedQuery("todosServicosNome");
		q.setParameter("nome", "%"+busca+"%");
		return q.getResultList();
	}
}
