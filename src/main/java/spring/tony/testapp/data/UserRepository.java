package spring.tony.testapp.data;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.tony.testapp.models.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
