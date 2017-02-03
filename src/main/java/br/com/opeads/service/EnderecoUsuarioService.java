package br.com.opeads.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.opeads.Exception.EnderecoJaExisteException;
import br.com.opeads.Exception.EnderecoNaoExisteException;
import br.com.opeads.model.EnderecoUsuario;
import br.com.opeads.model.Usuario;
import br.com.opeads.repository.EnderecoUsuarioRepository;
import br.com.opeads.service.genericinterfaceservice.GenericInterfaceService;

@Service
public class EnderecoUsuarioService implements GenericInterfaceService<EnderecoUsuario> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3768728213406357582L;
	
	@Autowired
	private EnderecoUsuarioRepository enderecoUsuarioRepository;
	
	@Autowired
	private UsuarioService usuarioService;

	@Override
	public List<EnderecoUsuario> listar() {
		return enderecoUsuarioRepository.findAll();
	}
	
	public EnderecoUsuario inserir(Long id, EnderecoUsuario enderecoUsuario) {
		Usuario usuario = new Usuario();
		EnderecoUsuario verificador = null;
		usuario.setId(id);
		usuario = usuarioService.buscaPorId(usuario);
		if(enderecoUsuario.getId() != null)verificador = enderecoUsuarioRepository.findOne(enderecoUsuario.getId());
		if(verificador != null)throw new EnderecoJaExisteException("O endereço informado já existe");
		enderecoUsuario.setUsuario(usuario);
		return enderecoUsuarioRepository.save(enderecoUsuario);
	}

	@Override
	public void remover(EnderecoUsuario enderecoUsuario) {
		buscaPorId(enderecoUsuario);
		enderecoUsuarioRepository.delete(enderecoUsuario);
	}

	@Override
	public EnderecoUsuario buscaPorId(EnderecoUsuario enderecoUsuario) {
		EnderecoUsuario verificador = enderecoUsuarioRepository.findOne(enderecoUsuario.getId());
		if(verificador == null)throw new EnderecoNaoExisteException("O endereço informado não existe");
		return enderecoUsuarioRepository.findOne(enderecoUsuario.getId());
	}
	
	public void alterar(Long id, EnderecoUsuario enderecoUsuario) {
		Usuario usuario = new Usuario();
		buscaPorId(enderecoUsuario);
		usuario = usuarioService.buscaPorId(usuario);
		enderecoUsuario.setUsuario(usuario);
		enderecoUsuarioRepository.save(enderecoUsuario);
	}

}
