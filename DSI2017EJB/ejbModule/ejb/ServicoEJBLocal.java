package ejb;

import java.util.List;
import javax.ejb.Local;
import model.Servico;

@Local
public interface ServicoEJBLocal {
	public List<Servico> todosServicos();
	public void remove(Servico servico);
	public void save(Servico servico);
	public List<Servico> todosServicos(String busca);
}
