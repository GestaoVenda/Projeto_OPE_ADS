package br.com.opeads.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.opeads.model.Usuario;
import br.com.opeads.service.genericinterfaceservice.GenericInterfaceService;

@Service
public class UsuarioService implements GenericInterfaceService<Usuario> {

	
	private static final long serialVersionUID = 8228376641665206323L;

	@Override
	public List<Usuario> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	public Usuario inserir(Usuario e) {
		// TODO Auto-generated method stub
		return null;
	}


	public void alterar(Usuario e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(Usuario e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Usuario buscaPorId(Usuario e) {
		// TODO Auto-generated method stub
		return null;
	}

}
