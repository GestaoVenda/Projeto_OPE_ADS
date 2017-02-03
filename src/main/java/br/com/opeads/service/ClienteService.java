package br.com.opeads.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.opeads.Exception.ClienteJaExisteException;
import br.com.opeads.Exception.ClienteNaoExisteException;
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

	public Cliente inserir(Cliente cliente) {
		Cliente verificador = null;
		if(cliente.getId() != null)verificador = clienteRepository.findOne(cliente.getId());
		if(cliente.getCnpj() != null)verificador = clienteRepository.findByCnpj(cliente.getCnpj());
		if(cliente.getCpf() != null)verificador = clienteRepository.findByCpf(cliente.getCpf());
		if(verificador != null)throw new ClienteJaExisteException("O cliente informado já existe");
		return clienteRepository.save(cliente);
	}

	public void alterar(Cliente  cliente) {
		buscaPorId(cliente);
		clienteRepository.save(cliente);
	}

	@Override
	public void remover(Cliente  cliente) {
		buscaPorId(cliente);
		clienteRepository.delete(cliente);
	}

	@Override
	public Cliente buscaPorId(Cliente cliente) {
		Cliente verificador = clienteRepository.findOne(cliente.getId());
		if(verificador == null)throw new ClienteNaoExisteException("O cliente informado não existe");
		return verificador;
	}


}
