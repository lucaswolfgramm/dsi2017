package ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Cliente;

/**
 * Session Bean implementation class ClienteEJB
 */
@Stateless
@LocalBean
public class ClienteEJB implements ClienteEJBLocal {

	/**
	 * Default constructor.
	 */
	@PersistenceContext(name = "dsi2017context")
	private EntityManager em;

	public ClienteEJB() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Cliente> todosClientes() {
		Query q = em.createNamedQuery("todosClientes");
		return q.getResultList();
	}

	@Override
	public void save(Cliente cliente) {
		if (em.find(Cliente.class, cliente.getOid()) == null) {
			// insert
			em.persist(cliente);
		} else {
			// update
			em.merge(cliente);
		}
	}

	@Override
	public void remove(Cliente cliente) {
		em.remove(em.find(Cliente.class, cliente.getOid()));
	}
}
