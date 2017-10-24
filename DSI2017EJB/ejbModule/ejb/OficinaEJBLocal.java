package ejb;

import java.util.List;
import javax.ejb.Local;
import model.Oficina;

@Local
public interface OficinaEJBLocal {
	public List<Oficina> todasOficinas();
	public void remove(Oficina oficina);
	public void save(Oficina oficina);
}
