package ru.grakovich.filmland.forms;

import lombok.Data;

@Data
public class FilmForm {
    private String title;
    private Integer year;
    private String genre;
}
