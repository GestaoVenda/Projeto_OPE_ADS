package br.com.opeads.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.opeads.model.TypeAddress;

@Repository
public interface TypeAddressRepository extends JpaRepository<TypeAddress, Long> {

}
