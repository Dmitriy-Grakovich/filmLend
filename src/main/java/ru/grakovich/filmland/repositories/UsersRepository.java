package ru.grakovich.filmland.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.grakovich.filmland.models.User;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);
    Optional<User> findById(Integer userid);
}
