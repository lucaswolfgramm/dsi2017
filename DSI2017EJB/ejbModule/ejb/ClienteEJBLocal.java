package ejb;

import java.util.List;
import javax.ejb.Local;
import model.Cliente;

@Local
public interface ClienteEJBLocal {
	public List<Cliente> todosClientes();
	public void remove(Cliente cliente);
	public void save(Cliente cliente);
}
