package br.com.opeads.service;

import java.util.List;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		
		if(usuario.getId() != null)verificador = usuarioRepository.findOne(usuario.getId());
		
		if(verificador != null)System.out.println("Usuario já existe!");
		
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
		Usuario verificador = usuarioRepository.findOne(usuario.getId());
		if(verificador == null)System.out.println("Usuario não existe");;
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
