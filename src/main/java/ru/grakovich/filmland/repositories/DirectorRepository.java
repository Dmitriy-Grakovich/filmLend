package ru.grakovich.filmland.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.grakovich.filmland.models.Director;

public interface DirectorRepository extends JpaRepository<Director, Integer> {

    Director getDirectorByFirstNameAndLastName(String firsName, String lastName);
}