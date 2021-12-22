package ru.grakovich.filmland.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.grakovich.filmland.models.Film;

public interface FilmRepository extends JpaRepository<Film, Integer> {

    Film getFilmByTitleAndYear(String title, Integer year);
}
