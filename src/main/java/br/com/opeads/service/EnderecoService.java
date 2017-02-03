package br.com.opeads.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.opeads.Exception.ClienteNaoExisteException;
import br.com.opeads.Exception.EnderecoJaExisteException;
import br.com.opeads.model.Cliente;
import br.com.opeads.model.Endereco;
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
	private ClienteService clienteService;

	@Override
	public List<Endereco> listar() {
		return enderecoRepository.findAll();
	}

	public Endereco inserir(Long id,Endereco endereco) {
		Cliente cliente = new Cliente();
		Endereco verificador = null;
		cliente.setId(id);
		cliente = clienteService.buscaPorId(cliente);
		if(endereco.getId() != null)verificador = enderecoRepository.findOne(endereco.getId());
		if(verificador != null)throw new EnderecoJaExisteException("O endereço informado já existe");
		endereco.setCliente(cliente);
		return enderecoRepository.save(endereco);
	}

	public void alterar(Long id,Endereco endereco) {
		Cliente cliente = new Cliente();
		cliente.setId(id);
		cliente = clienteService.buscaPorId(cliente);
		buscaPorId(endereco);
		endereco.setCliente(cliente);
		enderecoRepository.save(endereco);
	}

	@Override
	public void remover(Endereco endereco) {
		buscaPorId(endereco);
		enderecoRepository.delete(endereco);
	}

	@Override
	public Endereco buscaPorId(Endereco endereco) {
		Endereco verificador = enderecoRepository.findOne(endereco.getId());
		if(verificador == null)throw new ClienteNaoExisteException("O endereco informado não existe");
		return verificador;
	}

}
