package ru.grakovich.filmland.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "film")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "title")
    private String title;
    @Column(name = "year")
    private Integer year;
    @Column(name = "genre")
    private String genre;

    @ManyToOne
    @JoinColumn(name = "director_id")
    private Director director;

    @ManyToMany
    @JoinTable(
            name = "actor_film",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id"))
    private List<Actor> actors;

    @OneToOne
    @JoinColumn(name = "file_info_id")
    private FileInfo fileInfo;

    public void addActor(Actor actor){
        actors.add(actor);
        actor.getRemovedFilm().add(this);
    }
    public void removeActor(Actor actor){
        actors.remove(actor);
        actor.getRemovedFilm().remove(this);
    }
}
