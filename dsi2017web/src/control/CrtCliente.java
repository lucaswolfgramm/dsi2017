package control;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ejb.ClienteEJBLocal;
import model.Cliente;

@ManagedBean(name = "crtcliente")
@ViewScoped
public class CrtCliente {
	private String busca = "";
	
	@EJB
	private ClienteEJBLocal clienteEJB;

	private Cliente model = new Cliente();

	public Cliente getModel() {
		return model;
	}

	public void setModel(Cliente model) {
		this.model = model;
	}

	public List<Cliente> todosClientes() {
		if(busca.isEmpty()){
			return clienteEJB.todosClientes();
		}else{
			return clienteEJB.todosClientes(busca);
		}
	}

	public void insert() {
		model = new Cliente();
	}

	public void save() {
		clienteEJB.save(model);
	}

	public void remove() {
		if (model != null)
			clienteEJB.remove(model);
	}

	public String getBusca() {
		return busca;
	}

	public void setBusca(String busca) {
		this.busca = busca;
	}
}
