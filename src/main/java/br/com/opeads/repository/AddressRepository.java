package br.com.opeads.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.opeads.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{

}
