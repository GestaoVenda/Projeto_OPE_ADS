package br.com.opeads.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.opeads.model.Medida;
import br.com.opeads.repository.MedidaRepository;
import br.com.opeads.service.genericinterfaceservice.GenericInterfaceService;

@Service
public class MedidaService implements GenericInterfaceService<Medida>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4682415633538544201L;
	
	@Autowired
	private MedidaRepository medidaRepository;
	
	public Medida inserir(Medida medida) {
		Medida verificador = null;
		
		if(medida.getId() != null)verificador = medidaRepository.findOne(medida.getId());
		
		if(verificador != null)System.out.println("Medida já existe!");
		
		return medidaRepository.save(medida);
	}

	@Override
	public List<Medida> listar() {
		return medidaRepository.findAll();
	}

	@Override
	public void remover(Medida medida) {
		buscaPorId(medida);
		medidaRepository.delete(medida);
	}

	@Override
	public Medida buscaPorId(Medida medida) {
		Medida verificador = medidaRepository.findOne(medida.getId());
		if(verificador == null)System.out.println("Medida não existe");;
		return medidaRepository.findOne(medida.getId());
	}
	
	public void alterar(Medida  medida) {
		buscaPorId(medida);
		medidaRepository.save(medida);
	}

}
