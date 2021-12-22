package ru.grakovich.filmland.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.grakovich.filmland.service.FilesService;

import javax.servlet.http.HttpServletResponse;

@RequiredArgsConstructor
@Controller
public class FilesController {
    


    private final FilesService filesService;

    @GetMapping("/files/upload")
    public String getFilesUploadPage() {
        return "files_upload";
    }

    // GET http://localhost/files/faf94d48-aa7a-440b-830f-0661213685cd.jpg
    @GetMapping("/files/{id}")
    public void getFile(@PathVariable("id") Integer file_id, HttpServletResponse response) {
        filesService.addFileToResponseById(file_id, response);
    }

    @PostMapping("/files/upload")
    public String uploadFile(@RequestParam("description") String description, @RequestParam("file") MultipartFile multipartFile) {
        filesService.saveFile(description, multipartFile);
        return "redirect:/files/upload";
    }

}
