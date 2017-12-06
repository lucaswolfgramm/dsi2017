package ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.Usuario;

/**
 * Session Bean implementation class UsuarioEJB
 */
@Stateless
public class UsuarioEJB implements UsuarioEJBLocal {

	@PersistenceContext(name = "dsi2017context")
	private EntityManager em;

	public UsuarioEJB() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void criaUsuario(String usuario, String senha) {
		Usuario novoUsuario = new Usuario();
		novoUsuario.setUsuario(usuario);
		novoUsuario.setSenha(senha);
		em.persist(novoUsuario);

	}

	@Override
	public Usuario validaUsuario(String usuario, String senha) {
		try {
			Query q = em.createNamedQuery("validausuario");
			q.setParameter("usuario", usuario);
			q.setParameter("senha", senha);
			q.setMaxResults(1);
			return (Usuario) q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public List<Usuario> todosUsuarios() {
		Query q = em.createNamedQuery("todosUsuarios");
		return q.getResultList();
	}

	@Override
	public void save(Usuario usuario) {
		if (em.find(Usuario.class, usuario.getOid()) == null) {
			// insert
			em.persist(usuario);
		} else {
			// update
			em.merge(usuario);
		}		
	}
	
	@Override
	public void remove(Usuario usuario) {
		em.remove(em.find(Usuario.class, usuario.getOid()));
	}

	@Override
	public List<Usuario> todosUsuarios(String busca) {
		Query q = em.createNamedQuery("todosUsuariosNome");
		q.setParameter("nome", "%"+busca+"%");
		return q.getResultList();
	}

}