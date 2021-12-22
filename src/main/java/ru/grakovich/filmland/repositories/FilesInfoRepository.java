package ru.grakovich.filmland.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.grakovich.filmland.models.FileInfo;

public interface FilesInfoRepository extends JpaRepository<FileInfo,Long> {
    FileInfo findByStorageName(String storageName);
    FileInfo findById(Integer file_id);
}
