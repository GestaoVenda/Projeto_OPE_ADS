package br.com.opeads.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.opeads.model.Orcamento;
import br.com.opeads.service.genericinterfaceservice.GenericInterfaceService;

@Service
public class OrcamentoService implements GenericInterfaceService<Orcamento>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1909610880509024632L;

	@Override
	public List<Orcamento> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void inserir(Orcamento e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alterar(Orcamento e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(Orcamento e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Orcamento listarPorId(Orcamento e) {
		// TODO Auto-generated method stub
		return null;
	}

}
