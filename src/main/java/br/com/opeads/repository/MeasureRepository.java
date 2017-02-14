package br.com.opeads.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.opeads.model.Measure;

@Repository
public interface MeasureRepository extends JpaRepository<Measure, Long>{

	public Measure findByMeasureName(String measureName);
}
