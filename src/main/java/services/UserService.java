package services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.User;
import repository.UserRepo;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepo userrepo;

	public void saveUser(User user) {
		userrepo.save(user);
	}

	public List<User> showAllUsers() {
		List<User> users = new ArrayList<>();
		userrepo.findAll().forEach(users::add);
		return users;
	}

	public void deleteUser(int id) {
		userrepo.deleteById(id);
	}

	public void updateUser(User newUser) {
		Optional<User> optionalUser = userrepo.findById(newUser.getId());
		if (optionalUser.isPresent()) {
			User existingUser = optionalUser.get();
			existingUser.setUsername(newUser.getUsername());
			existingUser.setFirstname(newUser.getFirstname());
			existingUser.setLastname(newUser.getLastname());
			existingUser.setAge(newUser.getAge());
			existingUser.setPassword(newUser.getPassword());
			userrepo.save(existingUser); // Save the updated user
		} else {
			throw new RuntimeException("User not found with id: " + newUser.getId());
		}
	}

	public User findUserById(int id) {
		Optional<User> optionalUser = userrepo.findById(id);
		return optionalUser.orElse(null);
	}

	public User findByUsernameAndPassword(String username, String password) {
		return userrepo.findByUsernameAndPassword(username, password);
	}
}
