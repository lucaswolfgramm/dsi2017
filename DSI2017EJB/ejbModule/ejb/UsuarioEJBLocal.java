package ejb;

import java.util.List;
import javax.ejb.Local;
import model.Usuario;

@Local
public interface UsuarioEJBLocal {
	public void criaUsuario(String usuario, String senha);
	public Usuario validaUsuario(String usuario, String senha);
	public List<Usuario> todosUsuarios();
	public void remove(Usuario usuario);
	public void save(Usuario usuario);
	public List<Usuario> todosUsuarios(String busca);
}