package Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import DAO.ClienteDAO;
import Model.Cliente;

@Service
@Transactional
public class ClienteServiceImp implements ClienteService {
 
	@Autowired
	private ClienteDAO clientedao;
	
	@Override
	public boolean saveCliente(Cliente cliente) {
		return clientedao.saveCliente(cliente);
	}

	@Override
	public List<Cliente> getClientes() {
		return clientedao.getClientes();
	}

	@Override
	public boolean deleteCliente(Cliente cliente) {
		return clientedao.deleteCliente(cliente);
	}

	@Override
	public List<Cliente> getClienteByID(Cliente cliente) {
		return clientedao.getClienteByID(cliente);
	}

	@Override
	public boolean updateCliente(Cliente cliente) {
		return clientedao.updateCliente(cliente);
	}

}
