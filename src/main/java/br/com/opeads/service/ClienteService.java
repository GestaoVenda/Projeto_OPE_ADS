package br.com.opeads.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.opeads.model.Cliente;
import br.com.opeads.repository.ClienteRepository;
import br.com.opeads.service.genericinterfaceservice.GenericInterfaceService;

@Service
public class ClienteService implements GenericInterfaceService<Cliente>{

	private static final long serialVersionUID = -2564111722295953590L;
	
	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public List<Cliente> listar() {
		return clienteRepository.findAll();
	}

	@Override
	public void inserir(Cliente e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alterar(Cliente e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(Cliente e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cliente listarPorId(Cliente e) {
		// TODO Auto-generated method stub
		return null;
	}


}
