package io.github.dbarrerap.picbucket.controllers;

import io.github.dbarrerap.picbucket.services.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/picbucket")
public class PhotoController {
    @Autowired
    PhotoService service;

    @GetMapping("/photos")
    public Object index() {
        return service.findAll();
    }

    @GetMapping("/photos/{id}")
    public Object show(@PathVariable String id) {
        return service.findById(id);
    }

    @PostMapping("/photos")
    public Object store(@RequestParam MultipartFile file) throws IOException {
        return service.store(file);
    }
}
