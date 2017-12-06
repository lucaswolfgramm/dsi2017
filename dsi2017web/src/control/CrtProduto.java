package control;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ejb.ProdutoEJBLocal;
import model.Produto;

@ManagedBean(name = "crtproduto")
@ViewScoped
public class CrtProduto {
	
	private String busca = "";
	
	@EJB
	private ProdutoEJBLocal produtoEJB;

	private Produto model = new Produto();

	public Produto getModel() {
		return model;
	}

	public void setModel(Produto model) {
		this.model = model;
	}

	public List<Produto> todosProdutos() {
		if(busca.isEmpty()){
			return produtoEJB.todosProdutos();
		}else{
			return produtoEJB.todosProdutos(busca);
		}
	}

	public void insert() {
		model = new Produto();
	}

	public void save() {
		produtoEJB.save(model);
	}

	public void remove() {
		if (model != null)
			produtoEJB.remove(model);
	}

	public String getBusca() {
		return busca;
	}

	public void setBusca(String busca) {
		this.busca = busca;
	}
}
