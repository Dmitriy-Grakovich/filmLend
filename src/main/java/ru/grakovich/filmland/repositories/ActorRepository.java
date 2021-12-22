package ru.grakovich.filmland.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.grakovich.filmland.models.Actor;

public interface ActorRepository extends JpaRepository<Actor, Integer> {

    Actor getActorByFirstNameAndLastName(String firstName, String lastName);

}
