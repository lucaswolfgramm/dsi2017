package control;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ejb.OrcamentoEJBLocal;
import model.Orcamento;

@ManagedBean(name = "crtorcamento")
@ViewScoped
public class CrtOrcamento {
	
	private String busca = "";
	
	@EJB
	private OrcamentoEJBLocal orcamentoEJB;

	private Orcamento model = new Orcamento();

	public Orcamento getModel() {
		return model;
	}

	public void setModel(Orcamento model) {
		this.model = model;
	}

	public List<Orcamento> todosOrcamentos() {
		if(busca.isEmpty()){
			return orcamentoEJB.todosOrcamentos();
		}else{
			return orcamentoEJB.todosOrcamentos(busca);
		}
	}

	public void insert() {
		model = new Orcamento();
	}

	public void save() {
		orcamentoEJB.save(model);
	}

	public void remove() {
		if (model != null)
			orcamentoEJB.remove(model);
	}

	public String getBusca() {
		return busca;
	}

	public void setBusca(String busca) {
		this.busca = busca;
	}
}
