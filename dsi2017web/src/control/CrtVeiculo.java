package control;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ejb.VeiculoEJBLocal;
import model.Veiculo;

@ManagedBean(name = "crtveiculo")
@ViewScoped
public class CrtVeiculo {
	
	private String busca = "";
	
	@EJB
	private VeiculoEJBLocal veiculoEJB;

	private Veiculo model = new Veiculo();

	public Veiculo getModel() {
		return model;
	}

	public void setModel(Veiculo model) {
		this.model = model;
	}

	public List<Veiculo> todosVeiculos() {
		return veiculoEJB.todosVeiculos();
	}

	public void insert() {
		model = new Veiculo();
	}

	public void save() {
		veiculoEJB.save(model);
	}

	public void remove() {
		if (model != null)
			veiculoEJB.remove(model);
	}

	public String getBusca() {
		return busca;
	}

	public void setBusca(String busca) {
		this.busca = busca;
	}
}
