package br.com.opeads.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.opeads.model.Produto;
import br.com.opeads.repository.ProdutoRepository;
import br.com.opeads.service.genericinterfaceservice.GenericInterfaceService;

@Service
public class ProdutoService implements GenericInterfaceService<Produto> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2355847344019618836L;

	@Autowired
	private ProdutoRepository produtoRepository;
	
	public Produto inserir(Produto produto) {
		Produto verificador = null;
		
		if(produto.getId() != null)verificador = produtoRepository.findOne(produto.getId());
		
		if(verificador != null)System.out.println("Produto já existe!");
		
		return produtoRepository.save(produto);
	}
	
	@Override
	public List<Produto> listar() {
		return produtoRepository.findAll();
	}

	@Override
	public void remover(Produto produto) {
		buscaPorId(produto);
		produtoRepository.delete(produto);	
	}

	@Override
	public Produto buscaPorId(Produto produto) {
		Produto verificador = produtoRepository.findOne(produto.getId());
		if(verificador == null)System.out.println("Produto não existe");;
		return produtoRepository.findOne(produto.getId());
	}
	
	public void alterar(Produto  produto) {
		buscaPorId(produto);
		produtoRepository.save(produto);
	}

}
