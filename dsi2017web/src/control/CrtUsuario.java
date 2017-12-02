package control;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import ejb.UsuarioEJBLocal;
import model.Usuario;

@ManagedBean(name = "crtusuario")
@ViewScoped
public class CrtUsuario {
	
	private String busca = "";
	
	@EJB
	private UsuarioEJBLocal usuarioEJB;

	private Usuario model = new Usuario();

	public Usuario getModel() {
		return model;
	}

	public void setModel(Usuario model) {
		this.model = model;
	}

	public List<Usuario> todosUsuario() {
		if(busca.isEmpty()){
			return usuarioEJB.todosUsuario();
		}else{
			return usuarioEJB.todosUsuarios(busca);
		}
	}

	public void insert() {
		model = new Usuario();
	}

	public void save() {
		usuarioEJB.save(model);
	}

	public void remove() {
		if (model != null)
			usuarioEJB.remove(model);
	}

	public String getBusca() {
		return busca;
	}

	public void setBusca(String busca) {
		this.busca = busca;
	}
}