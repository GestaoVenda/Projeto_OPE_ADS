package br.com.opeads.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.opeads.model.Medida;

@Repository
public interface MedidaRepository extends JpaRepository<Medida, Long>{

	public Medida findByNomeMedida(String nomeMedida);
}
