package springrestAPI.springrestAPI.auth.repository;

import org.springframework.stereotype.Repository;
import springrestAPI.springrestAPI.auth.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Integer> {
    public User findByUsername(String username);
}
