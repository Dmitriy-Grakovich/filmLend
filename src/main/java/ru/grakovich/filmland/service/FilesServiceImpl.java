package ru.grakovich.filmland.service;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import ru.grakovich.filmland.models.FileInfo;
import ru.grakovich.filmland.repositories.FilesInfoRepository;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.UUID;

@RequiredArgsConstructor
@Component
public class FilesServiceImpl implements FilesService {
    @Value("${files.storage.path}")
    private String storageFolder;

    private final FilesInfoRepository filesInfoRepository;
    @Override
    public void saveFile(String description, MultipartFile multipartFile) {
        String originalFileName = multipartFile.getOriginalFilename();
        String extension = originalFileName.substring(originalFileName.indexOf("."));
        FileInfo fileInfo = FileInfo.builder()
                .originalName(originalFileName)
                .mimeType(multipartFile.getContentType())
                .description(description)
                .uploadDateTime(LocalDateTime.now())
                .size(multipartFile.getSize())
                .storageName(UUID.randomUUID() + extension)
                .build();
        filesInfoRepository.save(fileInfo);
        try {
            Files.copy(multipartFile.getInputStream(), Paths.get(storageFolder, fileInfo.getStorageName()));
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    /*@Override
    public void addFileToResponse(String fileName, HttpServletResponse response) {
        FileInfo fileInfo = filesInfoRepository.findByStorageName(fileName);

        response.setContentType(fileInfo.getMimeType());
        response.setContentLengthLong(fileInfo.getSize());
        response.setHeader("Content-Disposition", "filename\"" + fileInfo.getOriginalName() + "\"");
        try {
            Files.copy(Paths.get(storageFolder, fileInfo.getStorageName()), response.getOutputStream());
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }*/

    @Override
    public void addFileToResponseById(Integer file_id, HttpServletResponse response) {
        FileInfo fileInfo = filesInfoRepository.findById(file_id);

        response.setContentType(fileInfo.getMimeType());
        response.setContentLengthLong(fileInfo.getSize());
        response.setHeader("Content-Disposition", "filename\"" + fileInfo.getOriginalName() + "\"");
        try {
            Files.copy(Paths.get(storageFolder, fileInfo.getStorageName()), response.getOutputStream());
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
