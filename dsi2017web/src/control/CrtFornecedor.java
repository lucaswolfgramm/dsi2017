package control;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ejb.FornecedorEJBLocal;
import model.Fornecedor;

@ManagedBean(name = "crtfornecedor")
@ViewScoped
public class CrtFornecedor {
	@EJB
	private FornecedorEJBLocal fornecedorEJB;

	private Fornecedor model = new Fornecedor();

	public Fornecedor getModel() {
		return model;
	}

	public void setModel(Fornecedor model) {
		this.model = model;
	}

	public List<Fornecedor> todosFornecedores() {
		return fornecedorEJB.todosFornecedores();
	}

	public void insert() {
		model = new Fornecedor();
	}

	public void save() {
		fornecedorEJB.save(model);
	}

	public void remove() {
		if (model != null)
			fornecedorEJB.remove(model);
	}
}
