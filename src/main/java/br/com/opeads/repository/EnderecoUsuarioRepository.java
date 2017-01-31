package br.com.opeads.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.opeads.model.EnderecoUsuario;

@Repository
public interface EnderecoUsuarioRepository extends JpaRepository<EnderecoUsuario, Long>{

}
