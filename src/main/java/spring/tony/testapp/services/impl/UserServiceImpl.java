package spring.tony.testapp.services.impl;

import java.util.List;
import java.util.Optional;

import spring.tony.testapp.data.UserRepository;
import spring.tony.testapp.exceptions.NotFoundException;
import spring.tony.testapp.models.User;
import spring.tony.testapp.services.UserService;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
	

private UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User getUserById(long id) {
//		Optional<User> user = userRepository.findById(id);
//		if(user.isPresent()) {
//			return user.get();
//		}else {
//			throw new NotFoundException("User", "Id", id);
//		}
		return userRepository.findById(id).orElseThrow(() -> 
						new NotFoundException("User", "Id", id));
		
	}

	@Override
	public User updateUser(User user, long id) {
		
		// we need to check whether user with given id is exist in DB or not
		User existingUser = userRepository.findById(id).orElseThrow(
				() -> new NotFoundException("User", "Id", id)); 
		
		if(user.getUsername() != null) {
			existingUser.setUsername(user.getUsername());
		}
		if(user.getPassword() != null) {
			existingUser.setPassword(user.getPassword());
		}
		if(user.getName() != null) {
			existingUser.setName(user.getName());
		}
		if(user.getEmail() != null) {
			existingUser.setEmail(user.getEmail());
		}
		
		
		
		
		// save existing user to DB
		userRepository.save(existingUser);
		return existingUser;
	}

	@Override
	public void deleteUser(long id) {
		
		// check whether a user exist in a DB or not
		userRepository.findById(id).orElseThrow(() -> 
								new NotFoundException("User", "Id", id));
		userRepository.deleteById(id);
	}

}
