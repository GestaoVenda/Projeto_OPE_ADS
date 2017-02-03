package br.com.opeads.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.opeads.Exception.ClienteNaoExisteException;
import br.com.opeads.Exception.ContatoJaExisteException;
import br.com.opeads.model.Cliente;
import br.com.opeads.model.Contato;
import br.com.opeads.repository.ContatoRepository;
import br.com.opeads.service.genericinterfaceservice.GenericInterfaceService;

@Service
public class ContatoService implements GenericInterfaceService<Contato>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7992280903953485234L;

	@Autowired
	private ContatoRepository contatoRepository;
	
	@Autowired
	private ClienteService clienteService;
	
	@Override
	public List<Contato> listar() {
		return contatoRepository.findAll();
	}

	public Contato inserir(Long id, Contato contato) {
		Cliente cliente = new Cliente();
		Contato verificador = null;
		cliente.setId(id);
		cliente = clienteService.buscaPorId(cliente);
		if(contato.getId() != null)verificador = contatoRepository.findOne(contato.getId());
		if(verificador != null)throw new ContatoJaExisteException("O contato informado já existe");
		contato.setCliente(cliente);
		return contatoRepository.save(contato);
	}

	public void alterar(Long id,Contato contato) {
		Cliente cliente = new Cliente();
		cliente.setId(id);
		cliente = clienteService.buscaPorId(cliente);
		buscaPorId(contato);
		contato.setCliente(cliente);
		contatoRepository.save(contato);	
	}

	@Override
	public void remover(Contato contato) {
		buscaPorId(contato);
		contatoRepository.delete(contato);		
	}

	@Override
	public Contato buscaPorId(Contato contato) {
		Contato verificador = contatoRepository.findOne(contato.getId());
		if(verificador == null)throw new ClienteNaoExisteException("O contato informado não existe");
		return verificador;
	}

}
