package control;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ejb.ItemEJBLocal;
import model.Item;

@ManagedBean(name = "crtitem")
@ViewScoped
public class CrtItem {
	
	private String busca = "";
	
	@EJB
	private ItemEJBLocal itemEJB;

	private Item model = new Item();

	public Item getModel() {
		return model;
	}

	public void setModel(Item model) {
		this.model = model;
	}

	public List<Item> todosItens() {
		if(busca.isEmpty()){
			return itemEJB.todosItens();
		}else{
			return itemEJB.todosItens(busca);
		}
	}

	public void insert() {
		model = new Item();
	}

	public void save() {
		itemEJB.save(model);
	}

	public void remove() {
		if (model != null)
			itemEJB.remove(model);
	}

	public String getBusca() {
		return busca;
	}

	public void setBusca(String busca) {
		this.busca = busca;
	}
}
