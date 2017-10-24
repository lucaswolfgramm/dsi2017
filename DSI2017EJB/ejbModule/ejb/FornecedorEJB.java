package ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Fornecedor;

/**
 * Session Bean implementation class FornecedorEJB
 */
@Stateless
@LocalBean
public class FornecedorEJB implements FornecedorEJBLocal {

	/**
	 * Default constructor.
	 */
	@PersistenceContext(name = "dsi2017context")
	private EntityManager em;

	public FornecedorEJB() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Fornecedor> todosFornecedores() {
		Query q = em.createNamedQuery("todosFornecedores");
		return q.getResultList();
	}

	@Override
	public void save(Fornecedor fornecedor) {
		if (em.find(Fornecedor.class, fornecedor.getIdentificador()) == null) {
			// insert
			em.persist(fornecedor);
		} else {
			// update
			em.merge(fornecedor);
		}
	}

	@Override
	public void remove(Fornecedor fornecedor) {
		em.remove(em.find(Fornecedor.class, fornecedor.getIdentificador()));
	}
}
