package br.com.opeads.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.opeads.model.Cliente;
import br.com.opeads.model.Endereco;
import br.com.opeads.repository.ClienteRepository;
import br.com.opeads.repository.EnderecoRepository;
import br.com.opeads.service.genericinterfaceservice.GenericInterfaceService;

@Service
public class EnderecoService implements GenericInterfaceService<Endereco>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4470897900564721556L;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public List<Endereco> listar() {
		return enderecoRepository.findAll();
	}

	public Endereco inserir(Long id,Endereco endereco) {
		Cliente cliente = clienteRepository.findOne(id);
		endereco.setCliente(cliente);
		return enderecoRepository.save(endereco);
	}

	public void alterar(Long id,Endereco endereco) {
		buscaPorId(endereco);
		Cliente cliente = clienteRepository.findOne(id);
		endereco.setCliente(cliente);
		enderecoRepository.save(endereco);
	}

	@Override
	public void remover(Endereco endereco) {
		enderecoRepository.delete(endereco);
	}

	@Override
	public Endereco buscaPorId(Endereco endereco) {
		return enderecoRepository.findOne(endereco.getId());
	}

}
