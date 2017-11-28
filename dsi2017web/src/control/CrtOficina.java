package control;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ejb.OficinaEJBLocal;
import model.Oficina;

@ManagedBean(name = "crtoficina")
@ViewScoped
public class CrtOficina {
	
	private String busca = "";
	
	@EJB
	private OficinaEJBLocal oficinaEJB;

	private Oficina model = new Oficina();

	public Oficina getModel() {
		return model;
	}

	public void setModel(Oficina model) {
		this.model = model;
	}

	public List<Oficina> todasOficinas() {
		return oficinaEJB.todasOficinas();
	}

	public void insert() {
		model = new Oficina();
	}

	public void save() {
		oficinaEJB.save(model);
	}

	public void remove() {
		if (model != null)
			oficinaEJB.remove(model);
	}

	public String getBusca() {
		return busca;
	}

	public void setBusca(String busca) {
		this.busca = busca;
	}
}
