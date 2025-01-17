package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

	public User findByUsernameAndPassword(String username, String password);

}
