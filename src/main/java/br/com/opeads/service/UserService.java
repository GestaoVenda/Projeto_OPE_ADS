package br.com.opeads.service;

import java.util.List;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.opeads.exception.UserAlreadyExistsException;
import br.com.opeads.exception.UserDoesNotExistsException;
import br.com.opeads.model.User;
import br.com.opeads.repository.UserRepository;
import br.com.opeads.service.genericinterfaceservice.GenericInterfaceService;

@Service
public class UserService implements GenericInterfaceService<User> {

	
	private static final long serialVersionUID = 8228376641665206323L;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> read() {
		return userRepository.findAll();
	}

	public User create(User user) {
		User check = null;
		if(!user.getLogin().isEmpty())check = userRepository.findByLogin(user.getLogin());
		if(!user.getLogin().isEmpty())check = userRepository.findByEmail(user.getEmail());
		if(user.getId() != null)check = userRepository.findOne(user.getId());
		if(check != null)throw new UserAlreadyExistsException("O usuário informado já existe");
		return userRepository.save(user);
	}


	public void update(User user) {
		findById(user);
		userRepository.save(user);		
	}

	@Override
	public void delete(User user) {
		findById(user);
		userRepository.delete(user);	
	}

	@Override
	public User findById(User user) {
		User check = null;
		check = userRepository.findOne(user.getId());
		if(check == null)throw new UserDoesNotExistsException("O usuário informado não existe");
		return userRepository.findOne(user.getId());
	}

	public User auth(User user) throws ServletException{
		User check = userRepository.findByLogin(user.getLogin());
		if(check != null){
			if(user.getPassword().equals(check.getPassword())){
				return check;
			}
		}
		throw new ServletException("Usuário e/ou senha inválidos!");
	}

}
