package ejb;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Orcamento;

/**
 * Session Bean implementation class OrcamentoEJB
 */
@Stateless
@LocalBean
public class OrcamentoEJB implements OrcamentoEJBLocal {

	/**
	 * Default constructor.
	 */
	@PersistenceContext(name = "dsi2017context")
	private EntityManager em;

	public OrcamentoEJB() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Orcamento> todosOrcamentos() {
		Query q = em.createNamedQuery("todosOrcamentos");
		return q.getResultList();
	}

	@Override
	public void save(Orcamento orcamento) {
		if (em.find(Orcamento.class, orcamento.getOid()) == null) {
			// insert
			em.persist(orcamento);
		} else {
			// update
			em.merge(orcamento);
		}
	}

	@Override
	public void remove(Orcamento orcamento) {
		em.remove(em.find(Orcamento.class, orcamento.getIdentificador()));
	}

	@Override
	public List<Orcamento> todosOrcamentos(String busca) {
		Query q = em.createNamedQuery("todosOrcamentosNome");
		q.setParameter("nome", "%"+busca+"%");
		return q.getResultList();
	}
}
