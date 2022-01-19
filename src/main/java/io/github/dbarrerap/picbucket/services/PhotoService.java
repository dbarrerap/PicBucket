package io.github.dbarrerap.picbucket.services;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import io.github.dbarrerap.picbucket.entities.Photo;
import io.github.dbarrerap.picbucket.repositories.PhotoRepository;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class PhotoService {
    @Autowired
    private PhotoRepository repository;
    private GridFsTemplate template;

    public PhotoService(GridFsTemplate template) {
        this.template = template;
    }

    public List<Photo> findAll() {
        return repository.findAll();
    }

    public Photo findById(String id) {
        Optional<Photo> optional = repository.findById(id);
        return optional.orElse(null);
    }

    public Photo store(MultipartFile file) throws IOException {
        Photo photo = new Photo();
        photo.setFilename(file.getOriginalFilename());
        photo.setContentType(file.getContentType());
        photo.setSize(file.getSize());

        String resourceId = template.store(file.getInputStream(), file.getName()).toString();

        photo.setResourceId(resourceId);

        return repository.save(photo);
    }
}
