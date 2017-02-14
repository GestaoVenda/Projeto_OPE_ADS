package br.com.opeads.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.opeads.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

	public Client findByCnpj(String cnpj);
	
	public Client findByCpf(String cnpj);
}
