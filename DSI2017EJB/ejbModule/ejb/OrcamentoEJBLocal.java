package ejb;

import java.util.List;
import javax.ejb.Local;
import model.Orcamento;

@Local
public interface OrcamentoEJBLocal {
	public List<Orcamento> todosOrcamentos();
	public void remove(Orcamento orcamento);
	public void save(Orcamento orcamento);
}
