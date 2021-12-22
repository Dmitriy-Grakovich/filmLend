package ru.grakovich.filmland.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.grakovich.filmland.forms.FilmForm;
import ru.grakovich.filmland.models.Actor;
import ru.grakovich.filmland.models.Director;
import ru.grakovich.filmland.models.Film;
import ru.grakovich.filmland.service.FilmService;

import java.util.List;

@RequestMapping("/")
@Controller
public class FilmController {

    private final FilmService filmService;

    @Autowired
    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping
    public String filmsAll(Model model){
        List<Film> films = filmService.getAllFilm();
        model.addAttribute("filmList", films);
        return "films";
    }
    @GetMapping("/film_add")
    public String addFilm(){
        return "film_add";
    }

    @GetMapping("/viewing/{id}")
    public String getFilmPlay(Model model, @PathVariable("id") Integer filmId) {
        Film film = filmService.getFilm(filmId);
        model.addAttribute("film", film);
        return "viewing";
    }

    @GetMapping("/director/{id}")
    public String getDirectorPage(Model model, @PathVariable("id") Integer director_id) {
        Director director = filmService.getDirector(director_id);
        model.addAttribute("director", director);
        return "director";
    }
    @GetMapping("/actor/{id}")
    public String getActorPage(Model model, @PathVariable("id") Integer actor_id) {
        Actor actor = filmService.getActor(actor_id);
        model.addAttribute("actor", actor);
        return "actor";
    }
    @GetMapping("/film/{id}")
    public String getFilmPage(Model model, @PathVariable("id") Integer film_id){
        Film film = filmService.getFilm(film_id);
        model.addAttribute("film", film);
        return "film";
    }

    @GetMapping("/filmUpdate/{id}")
    public String filmUpdate(@PathVariable("id") Integer film_Id, Model model){
        Film film = filmService.getFilm(film_Id);
        model.addAttribute("film", film);
        return "film_update";
    }
    @PostMapping("/updateFilm/{id}")
    public String filmUpdate( FilmForm filmForm, @PathVariable("id") Integer id, @RequestParam("director") String director,
                              @RequestParam("actor1") String actor1, @RequestParam("actor2") String actor2, @RequestParam("actor3") String actor3){
        filmService.update(filmForm, id,director, actor1, actor2, actor3);
        return "redirect:/";
    }

    @PostMapping("/addFilm")
    public String createFilm(FilmForm filmForm, @RequestParam("director") String directorFullname,
                          @RequestParam("actor1") String actor1, @RequestParam("actor2") String actor2,
                             @RequestParam("actor3") String actor3) {
        filmService.addFilm(filmForm, directorFullname, actor1, actor2, actor3);
        return "redirect:/";
    }

    @PostMapping("/film/{id}/delete")
    public String deleteFilm(@PathVariable("id") Integer film_Id) {
        filmService.deleteFilm(film_Id);
        return "redirect:/";
    }

}
