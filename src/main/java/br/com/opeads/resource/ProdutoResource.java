package br.com.opeads.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.opeads.service.ProdutoService;

@RestController
@RequestMapping(value = "/API/Produto", produces = { MediaType.APPLICATION_JSON_VALUE })
public class ProdutoResource {

	@Autowired
	private ProdutoService produtoService;
}
