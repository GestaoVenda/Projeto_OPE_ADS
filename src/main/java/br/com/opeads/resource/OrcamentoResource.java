package br.com.opeads.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.opeads.service.OrcamentoService;

@RestController
@RequestMapping(value = "/API/Orcamento", produces = { MediaType.APPLICATION_JSON_VALUE})
public class OrcamentoResource {

	@Autowired
	private OrcamentoService orcamentoService;
}
