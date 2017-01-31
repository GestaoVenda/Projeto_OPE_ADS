package br.com.opeads.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.opeads.model.Cliente;
import br.com.opeads.model.Contato;
import br.com.opeads.repository.ClienteRepository;
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
	private ClienteRepository clienteRepository;
	
	@Override
	public List<Contato> listar() {
		return contatoRepository.findAll();
	}

	public Contato inserir(Long id, Contato contato) {
		Cliente cliente = clienteRepository.findOne(id);
		contato.setCliente(cliente);
		return contatoRepository.save(contato);
	}

	public void alterar(Long id,Contato contato) {
		buscaPorId(contato);
		Cliente cliente = clienteRepository.findOne(id);
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
		return contatoRepository.findOne(contato.getId());
	}

}
