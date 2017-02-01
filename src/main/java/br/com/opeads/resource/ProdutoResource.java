package br.com.opeads.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.opeads.model.Produto;
import br.com.opeads.service.ProdutoService;

@CrossOrigin
@RestController
@RequestMapping(value = "/api",produces = {MediaType.APPLICATION_JSON_VALUE})
public class ProdutoResource {

	@Autowired
	private ProdutoService produtoService;
	
	@RequestMapping(value = "/list/produto")
	public ResponseEntity<List<Produto>> listar(){
		return ResponseEntity.ok().body(produtoService.listar());
	}
	
	@RequestMapping(value = "/save/produto", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Void> inserir(@RequestBody Produto produto){
		produto = produtoService.inserir(produto);
		URI uri = ServletUriComponentsBuilder.fromPath("http://localhost:8080/api/find/produto/"+produto.getId()).build().toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/edit/produto", method = RequestMethod.PUT, consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Void> alterar(@RequestBody Produto produto){
		produtoService.alterar(produto);
		return ResponseEntity.accepted().build();
	}
	
	@RequestMapping(value = "/delete/produto", method = RequestMethod.DELETE, consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Void> deletar(@RequestBody Produto produto){
		produtoService.remover(produto);
		return ResponseEntity.accepted().build();
	}
}
