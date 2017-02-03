package br.com.opeads.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.opeads.Exception.CategoriaJaExisteException;
import br.com.opeads.Exception.CategoriaNaoExisteException;
import br.com.opeads.model.Categoria;
import br.com.opeads.repository.CategoriaRepository;
import br.com.opeads.service.genericinterfaceservice.GenericInterfaceService;

@Service
public class CategoriaService implements GenericInterfaceService<Categoria>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1176416519887255379L;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Categoria inserir(Categoria categoria) {
		Categoria verificador = null;
		if(!categoria.getNomeCategoria().isEmpty())verificador = categoriaRepository.findBynomeCategoria(categoria.getNomeCategoria());
		if(categoria.getId() != null)verificador = categoriaRepository.findOne(categoria.getId());
		if(verificador != null)throw new CategoriaJaExisteException("A categoria informada já existe");
		return categoriaRepository.save(categoria);
	}

	@Override
	public List<Categoria> listar() {
		return categoriaRepository.findAll();
	}

	@Override
	public void remover(Categoria categoria) {
		buscaPorId(categoria);
		categoriaRepository.delete(categoria);		
	}

	@Override
	public Categoria buscaPorId(Categoria categoria) {
		Categoria verificador = categoriaRepository.findOne(categoria.getId());
		if(verificador == null)throw new CategoriaNaoExisteException("A categoria informada não existe");;
		return verificador;
	}
	
	public void alterar(Categoria  categoria) {
		buscaPorId(categoria);
		categoriaRepository.save(categoria);
	}

}
