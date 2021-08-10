package DAO;

import java.util.List;

import Model.Cliente;

public interface ClienteDAO {

	public boolean saveCliente(Cliente cliente);
	public List<Cliente> getClientes();
	public boolean deleteCliente(Cliente cliente);
	public List<Cliente> getClienteByID(Cliente cliente);
	public boolean updateCliente(Cliente cliente);
}
