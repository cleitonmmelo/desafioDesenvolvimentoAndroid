package Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Model.Cliente;
import Model.User;
import Service.ClienteService;

@RestController
@CrossOrigin(origins="http://localhost:8081")
@RequestMapping(value="/api")
public class Controller {
	
	@Autowired
	private ClienteService clienteservice;
	
	@PostMapping("save-cliente")
	public boolean saveCliente(@RequestBody Cliente cliente) {
		System.out.println(cliente.getCliente_nome());
		 return clienteservice.saveCliente(cliente);
		
	}
	@PostMapping("users/authenticate")
	public User authenticate(@RequestBody User user) throws Exception {
		
//		if(user.getUsername() == "admin" && user.getPassword() == "123456") {
			user.setToken("fake-jwt-token");
			user.setIsAdm(true);
			return user;
//		}

//		if(user.getUsername() == "comum" && user.getPassword() == "123456") {
//			user.setToken("fake-jwt-token");
//			user.setIsAdm(false);
//			return user;
//		}
//		
//		throw new Exception("Usuário e senha invalidos!");
		
	}
	
	@GetMapping("clientes-list")
	public List<Cliente> allclientes() {
		 return clienteservice.getClientes();
	}
	
	
	@DeleteMapping("delete-cliente/{cliente_id}")
	public boolean deleteCliente(@PathVariable("cliente_id") int cliente_id,Cliente cliente) {
		cliente.setCliente_id(cliente_id);
		return clienteservice.deleteCliente(cliente);
	}

	@GetMapping("cliente/{cliente_id}")
	public List<Cliente> allclienteByID(@PathVariable("cliente_id") int cliente_id,Cliente cliente) {
		 cliente.setCliente_id(cliente_id);
		 return clienteservice.getClienteByID(cliente);
		
	}
	
	@PostMapping("update-cliente/{cliente_id}")
	public boolean updateCliente(@RequestBody Cliente cliente,@PathVariable("cliente_id") int cliente_id) {
		cliente.setCliente_id(cliente_id);
		return clienteservice.updateCliente(cliente);
	}
}
