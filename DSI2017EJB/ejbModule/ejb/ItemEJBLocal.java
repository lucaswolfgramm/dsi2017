package ejb;

import java.util.List;
import javax.ejb.Local;
import model.Item;

@Local
public interface ItemEJBLocal {
	public List<Item> todosItens();
	public void remove(Item item);
	public void save(Item item);
}
