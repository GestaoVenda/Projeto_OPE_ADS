package br.com.opeads.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.opeads.model.UserAddress;

@Repository
public interface UserAddressRepository extends JpaRepository<UserAddress, Long>{

}
