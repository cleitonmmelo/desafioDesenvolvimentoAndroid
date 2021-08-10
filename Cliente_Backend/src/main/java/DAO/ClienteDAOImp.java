package DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import Model.Cliente;

@Repository
public class ClienteDAOImp  implements ClienteDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean saveCliente(Cliente cliente) {
		boolean status=false;
		try {
			sessionFactory.getCurrentSession().save(cliente);
			status=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public List<Cliente> getClientes() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Cliente> query=currentSession.createQuery("from Cliente", Cliente.class);
		List<Cliente> list=query.getResultList();
		return list;
	}

	@Override
	public boolean deleteCliente(Cliente cliente) {
		boolean status=false;
		try {
			sessionFactory.getCurrentSession().delete(cliente);
			status=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public List<Cliente> getClienteByID(Cliente cliente) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Cliente> query=currentSession.createQuery("from Cliente where cliente_id=:cliente_id", Cliente.class);
		query.setParameter("cliente_id", cliente.getCliente_id());
		List<Cliente> list=query.getResultList();
		return list;
	}

	@Override
	public boolean updateCliente(Cliente cliente) {
		boolean status=false;
		try {
			sessionFactory.getCurrentSession().update(cliente);
			status=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	

}
