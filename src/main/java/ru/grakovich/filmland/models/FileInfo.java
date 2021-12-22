package ru.grakovich.filmland.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class FileInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String description;
    private String originalName;
    private String storageName;
    private String mimeType;
    private Long size;

    private LocalDateTime uploadDateTime;

    @OneToOne(mappedBy = "fileInfo")
    private Film film;


}
