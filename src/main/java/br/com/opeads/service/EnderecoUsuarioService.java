package br.com.opeads.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.opeads.model.EnderecoUsuario;
import br.com.opeads.repository.EnderecoUsuarioRepository;
import br.com.opeads.service.genericinterfaceservice.GenericInterfaceService;

public class EnderecoUsuarioService implements GenericInterfaceService<EnderecoUsuario> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3768728213406357582L;
	
	@Autowired
	private EnderecoUsuarioRepository enderecoUsuarioRepository;

	@Override
	public List<EnderecoUsuario> listar() {
		return enderecoUsuarioRepository.findAll();
	}

	@Override
	public void remover(EnderecoUsuario enderecoUsuario) {
		buscaPorId(enderecoUsuario);
		enderecoUsuarioRepository.delete(enderecoUsuario);
	}

	@Override
	public EnderecoUsuario buscaPorId(EnderecoUsuario enderecoUsuario) {
		EnderecoUsuario verificador = enderecoUsuarioRepository.findOne(enderecoUsuario.getId());
		if(verificador == null)System.out.println("Endereço não existe");;
		return enderecoUsuarioRepository.findOne(enderecoUsuario.getId());
	}
	
	public void alterar(EnderecoUsuario enderecoUsuario) {
		buscaPorId(enderecoUsuario);
		enderecoUsuarioRepository.save(enderecoUsuario);		
	}

}
