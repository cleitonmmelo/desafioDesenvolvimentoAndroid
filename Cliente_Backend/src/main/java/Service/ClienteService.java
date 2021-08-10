package Service;

import java.util.List;

import Model.Cliente;

public interface ClienteService {

	
	public boolean saveCliente(Cliente cliente);
	public List<Cliente> getClientes();
	public boolean deleteCliente(Cliente cliente);
	public List<Cliente> getClienteByID(Cliente cliente);
	public boolean updateCliente(Cliente cliente);
}
