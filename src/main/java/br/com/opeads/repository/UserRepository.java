package br.com.opeads.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.opeads.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{

	User findByLogin(String login);

	User findByEmail(String email);
}
