package br.com.opeads.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.opeads.Exception.AddressAlreadyExistsException;
import br.com.opeads.Exception.AddressDoesNotExistsException;
import br.com.opeads.model.UserAddress;
import br.com.opeads.model.User;
import br.com.opeads.repository.UserAddressRepository;
import br.com.opeads.service.genericinterfaceservice.GenericInterfaceService;

@Service
public class UserAddressService implements GenericInterfaceService<UserAddress> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3768728213406357582L;
	
	@Autowired
	private UserAddressRepository userAddressRepository;
	
	@Autowired
	private UserService userService;

	@Override
	public List<UserAddress> read() {
		return userAddressRepository.findAll();
	}
	
	public UserAddress create(Long id, UserAddress userAddress) {
		User user = new User();
		UserAddress check = null;
		user.setId(id);
		user = userService.findById(user);
		if(userAddress.getId() != null)check = userAddressRepository.findOne(userAddress.getId());
		if(check != null)throw new AddressAlreadyExistsException("O endereço informado já existe");
		userAddress.setUser(user);
		return userAddressRepository.save(userAddress);
	}

	@Override
	public void delete(UserAddress userAddress) {
		findById(userAddress);
		userAddressRepository.delete(userAddress);
	}

	@Override
	public UserAddress findById(UserAddress userAddress) {
		UserAddress check = userAddressRepository.findOne(userAddress.getId());
		if(check == null)throw new AddressDoesNotExistsException("O endereço informado não existe");
		return userAddressRepository.findOne(userAddress.getId());
	}
	
	public void update(Long id, UserAddress userAddress) {
		User user = new User();
		findById(userAddress);
		user = userService.findById(user);
		userAddress.setUser(user);
		userAddressRepository.save(userAddress);
	}

}
