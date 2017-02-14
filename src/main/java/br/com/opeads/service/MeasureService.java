package br.com.opeads.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.opeads.Exception.MeasureAlreadyExistsException;
import br.com.opeads.Exception.MeasureDoesNotExistsException;
import br.com.opeads.model.Measure;
import br.com.opeads.repository.MeasureRepository;
import br.com.opeads.service.genericinterfaceservice.GenericInterfaceService;

@Service
public class MeasureService implements GenericInterfaceService<Measure>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4682415633538544201L;
	
	@Autowired
	private MeasureRepository measureRepository;
	
	public Measure create(Measure measure) {
		Measure check = null;
		if(!measure.getMeasureName().isEmpty())check = measureRepository.findByMeasureName(measure.getMeasureName());
		if(measure.getId() != null)check = measureRepository.findOne(measure.getId());
		if(check != null)throw new MeasureAlreadyExistsException("A medida informada já existe");
		return measureRepository.save(measure);
	}

	@Override
	public List<Measure> read() {
		return measureRepository.findAll();
	}

	@Override
	public void delete(Measure measure) {
		findById(measure);
		measureRepository.delete(measure);
	}

	@Override
	public Measure findById(Measure measure) {
		Measure check = measureRepository.findOne(measure.getId());
		if(check == null)throw new MeasureDoesNotExistsException("A medida informada não existe");
		return measureRepository.findOne(measure.getId());
	}
	
	public void update(Measure  measure) {
		findById(measure);
		measureRepository.save(measure);
	}

}
