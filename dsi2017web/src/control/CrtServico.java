package control;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ejb.ServicoEJBLocal;
import model.Servico;

@ManagedBean(name = "crtservico")
@ViewScoped
public class CrtServico {
	@EJB
	private ServicoEJBLocal servicoEJB;

	private Servico model = new Servico();

	public Servico getModel() {
		return model;
	}

	public void setModel(Servico model) {
		this.model = model;
	}

	public List<Servico> todosServicos() {
		return servicoEJB.todosServicos();
	}

	public void insert() {
		model = new Servico();
	}

	public void save() {
		servicoEJB.save(model);
	}

	public void remove() {
		if (model != null)
			servicoEJB.remove(model);
	}
}
