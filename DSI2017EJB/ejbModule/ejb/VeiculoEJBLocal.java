package ejb;

import java.util.List;
import javax.ejb.Local;
import model.Veiculo;

@Local
public interface VeiculoEJBLocal {
	public List<Veiculo> todosVeiculos();
	public void remove(Veiculo veiculo);
	public void save(Veiculo veiculo);
}
