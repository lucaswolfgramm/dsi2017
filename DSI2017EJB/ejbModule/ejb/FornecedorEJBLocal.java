package ejb;

import java.util.List;
import javax.ejb.Local;
import model.Fornecedor;

@Local
public interface FornecedorEJBLocal {
	public List<Fornecedor> todosFornecedores();
	public void remove(Fornecedor fornecedor);
	public void save(Fornecedor fornecedor);
}
