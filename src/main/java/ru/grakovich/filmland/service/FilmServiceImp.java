package ru.grakovich.filmland.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.grakovich.filmland.exceptions.FormNotFoundException;
import ru.grakovich.filmland.forms.FilmForm;
import ru.grakovich.filmland.models.Actor;
import ru.grakovich.filmland.models.Director;
import ru.grakovich.filmland.models.Film;
import ru.grakovich.filmland.models.User;
import ru.grakovich.filmland.repositories.ActorRepository;
import ru.grakovich.filmland.repositories.DirectorRepository;
import ru.grakovich.filmland.repositories.FilmRepository;
import ru.grakovich.filmland.repositories.UsersRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class FilmServiceImp<T> implements FilmService {

    private final DirectorRepository directorRepository;
    private final FilmRepository filmRepository;
    private final ActorRepository actorRepository;
    private final UsersRepository usersRepository;

    @Override
    public void addFilm(FilmForm filmForm, String directorFullName, String actor1, String actor2, String actor3) {
        Film film = film_add(filmForm, directorFullName);
        if(actorRepository.getActorByFirstNameAndLastName("A","a")!=null){
            actorRepository.deleteById(actorRepository.getActorByFirstNameAndLastName("A","a").getId());
        }
        String[] actors = {actor1, actor2, actor3, "A a"};
        for (String st : actors) {
            if(!st.equals("")){
               Actor actor = actoris(getName(st));
                if(!film.getActors().contains(actor)){
                    film.addActor(actor);
                }
            }
        }
    }

    private Film film_add(FilmForm filmForm, String directorFullname){
        Director director = director(getName(directorFullname));
        Film film = filmRepository.getFilmByTitleAndYear(filmForm.getTitle(),filmForm.getYear());
        if(film==null){
            film = Film.builder()
                    .title(filmForm.getTitle())
                    .year(filmForm.getYear())
                    .genre(filmForm.getGenre())
                    .director(director)
                    .actors(new ArrayList<>())
                    .build();
        }
        filmRepository.save(film);
        return film;
    }

    private String[] getName(String str){
        String[] name = str.split(" ");
        String firstName = name[0];
        String lastName ="";
        switch (name.length){
            case 2:lastName = name[1];
                break;
            case 3:lastName = name[1] + " " + name[2];
                break;
            case 4:lastName = name[1] + " " + name[2] + " " + name[3];
                break;
        }
        String[] result ={firstName,lastName};
        return result;
    }

    // если такого director нет в базе, добавляем в базу, возвращаем его id
    private Director director(String[] str){
        
        Director director = directorRepository.getDirectorByFirstNameAndLastName(str[0], str[1]);
        if(director==null) {
            director = Director.builder()
                    .firstName(str[0])
                    .lastName(str[1])
                    .build();
            directorRepository.save(director);
        }
        directorRepository.save(director);
        return director;
    }
     
    //если такого actor нет в базе, добавляем в базу, возвращаем его id
    private Actor actoris(String[] str){

        Actor actor = actorRepository.getActorByFirstNameAndLastName(str[0],str[1]);
        if(actor==null) {
            actor = Actor.builder()
                    .firstName(str[0])
                    .lastName(str[1])
                    .removedFilm(new ArrayList<>())
                    .build();
        }
        actorRepository.save(actor);
        return actor;
    }

    @Override
    public List<Film> getAllFilm() {
        return filmRepository.findAll();
    }

    @Override
    public Film getFilm(Integer filmId) {
        Optional<Film> optional = filmRepository.findById(filmId);
        return optional.orElseThrow(FormNotFoundException::new);
    }

    @Override
    public Director getDirector(Integer director_id) {
        Optional<Director> optional = directorRepository.findById(director_id);
        return optional.orElseThrow(FormNotFoundException::new);
    }

    @Override
    public Actor getActor(Integer actor_id) {
        Optional<Actor> optional = actorRepository.findById(actor_id);
        return optional.orElseThrow(FormNotFoundException::new);
    }

    @Override
    public User getUser(Integer user_id) {
        return usersRepository.getById(user_id);
    }

    @Override
    public void deleteFilm(Integer film_id) {
        filmRepository.getById(film_id).getActors().clear();
        filmRepository.deleteById(film_id);
    }

    @Override
    public void update(FilmForm filmForm,Integer id, String dir, String actor1, String actor2, String actor3) {
        Film film = filmRepository.getById(id);
        if(!filmForm.getTitle().equals(""))
            film.setTitle(filmForm.getTitle());
        if(filmForm.getYear()!=null)
            film.setYear(filmForm.getYear());
        if(!filmForm.getGenre().equals(""))
            film.setGenre(filmForm.getGenre());
        if(!dir.equals("")){
            film.setDirector(director(getName(dir)));
        }
        List<Actor> newListActor = film.getActors();
        if(!actor1.equals("")){
            newListActor.remove(0);
            newListActor.add(0, actoris(getName(actor1)));
        }
        if(!actor2.equals("")){
            newListActor.remove(1);
            newListActor.add(1, actoris(getName(actor2)));
        }
        if(!actor3.equals("")){
            newListActor.remove(2);
            newListActor.add(2, actoris(getName(actor3)));
        }
        film.setActors(newListActor);
        filmRepository.save(film);
    }

}
