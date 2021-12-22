package ru.grakovich.filmland.service;

import ru.grakovich.filmland.forms.FilmForm;
import ru.grakovich.filmland.models.Actor;
import ru.grakovich.filmland.models.Director;
import ru.grakovich.filmland.models.Film;
import ru.grakovich.filmland.models.User;

import java.util.List;

public interface FilmService {
    void addFilm(FilmForm filmForm, String directorFullName, String actor1, String actor2, String actor3);
    List<Film> getAllFilm();
    Film getFilm(Integer filmId);
    Director getDirector(Integer director_id);
    Actor getActor(Integer actor_id);
    User getUser(Integer user_id);
    void deleteFilm(Integer film_id);
    void update(FilmForm filmForm,Integer id, String director, String actor1, String actor2, String actor3);
}
