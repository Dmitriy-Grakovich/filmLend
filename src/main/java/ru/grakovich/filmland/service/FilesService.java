package ru.grakovich.filmland.service;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

public interface FilesService {
    void saveFile(String description, MultipartFile multipartFile);

   // void addFileToResponse(String fileName, HttpServletResponse response);

    void addFileToResponseById(Integer file_id, HttpServletResponse response);
}
