package ejb;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.Item;

/**
 * Session Bean implementation class ItemEJB
 */
@Stateless
@LocalBean
public class ItemEJB implements ItemEJBLocal {

	/**
	 * Default constructor.
	 */
	@PersistenceContext(name = "dsi2017context")
	private EntityManager em;

	public ItemEJB() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Item> todosItens() {
		Query q = em.createNamedQuery("todosItens");
		return q.getResultList();
	}

	@Override
	public void save(Item item) {
		if (em.find(Item.class, item.getOid()) == null) {
			// insert
			em.persist(item);
		} else {
			// update
			em.merge(item);
		}
	}

	@Override
	public void remove(Item item) {
		em.remove(em.find(Item.class, item.getOid()));
	}

	@Override
	public List<Item> todosItens(String busca) {
		Query q = em.createNamedQuery("todosItensNome");
		q.setParameter("nome", "%"+busca+"%");
		return q.getResultList();
	}
}
