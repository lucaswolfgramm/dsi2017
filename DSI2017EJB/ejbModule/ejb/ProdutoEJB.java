package ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Produto;

/**
 * Session Bean implementation class ProdutoEJB
 */
@Stateless
@LocalBean
public class ProdutoEJB implements ProdutoEJBLocal {

	/**
	 * Default constructor.
	 */
	@PersistenceContext(name = "dsi2017context")
	private EntityManager em;

	public ProdutoEJB() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Produto> todosProdutos() {
		Query q = em.createNamedQuery("todosProdutos");
		return q.getResultList();
	}

	@Override
	public void save(Produto produto) {
		if (em.find(Produto.class, produto.getIdentificador()) == null) {
			// insert
			em.persist(produto);
		} else {
			// update
			em.merge(produto);
		}
	}

	@Override
	public void remove(Produto produto) {
		em.remove(em.find(Produto.class, produto.getIdentificador()));
	}
}
