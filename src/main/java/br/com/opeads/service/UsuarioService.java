package br.com.opeads.service;

import java.util.List;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.opeads.Exception.UsuarioJaExisteException;
import br.com.opeads.Exception.UsuarioNaoExisteException;
import br.com.opeads.model.Usuario;
import br.com.opeads.repository.UsuarioRepository;
import br.com.opeads.service.genericinterfaceservice.GenericInterfaceService;

@Service
public class UsuarioService implements GenericInterfaceService<Usuario> {

	
	private static final long serialVersionUID = 8228376641665206323L;
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public List<Usuario> listar() {
		return usuarioRepository.findAll();
	}

	public Usuario inserir(Usuario usuario) {
		Usuario verificador = null;
		if(!usuario.getLogin().isEmpty())verificador = usuarioRepository.findByLogin(usuario.getLogin());
		if(!usuario.getLogin().isEmpty())verificador = usuarioRepository.findByEmail(usuario.getEmail());
		if(usuario.getId() != null)verificador = usuarioRepository.findOne(usuario.getId());
		if(verificador != null)throw new UsuarioJaExisteException("O usuário informado já existe");
		return usuarioRepository.save(usuario);
	}


	public void alterar(Usuario usuario) {
		buscaPorId(usuario);
		usuarioRepository.save(usuario);		
	}

	@Override
	public void remover(Usuario usuario) {
		buscaPorId(usuario);
		usuarioRepository.delete(usuario);	
	}

	@Override
	public Usuario buscaPorId(Usuario usuario) {
		Usuario verificador = null;
		verificador = usuarioRepository.findOne(usuario.getId());
		if(verificador == null)throw new UsuarioNaoExisteException("O usuário informado não existe");
		return usuarioRepository.findOne(usuario.getId());
	}

	public Usuario autenticar(Usuario usuario) throws ServletException{
		Usuario consulta = usuarioRepository.findByLogin(usuario.getLogin());
		if(consulta != null){
			if(usuario.getSenha().equals(consulta.getSenha())){
				return consulta;
			}
		}
		throw new ServletException("Usuário e/ou senha inválidos!");
	}

}
