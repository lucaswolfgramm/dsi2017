package ejb;

import java.util.List;
import javax.ejb.Local;
import model.Produto;

@Local
public interface ProdutoEJBLocal {
	public List<Produto> todosProdutos();
	public void remove(Produto produto);
	public void save(Produto produto);
}
