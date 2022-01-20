package io.github.dbarrerap.picbucket.services;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.gridfs.model.GridFSFile;
import io.github.dbarrerap.picbucket.entities.Photo;
import io.github.dbarrerap.picbucket.repositories.PhotoRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j @AllArgsConstructor
public class PhotoService {
    @Autowired
    private final PhotoRepository repository;
    private final GridFsTemplate template;

    public List<Photo> findAll() {
        log.info("* Retrieving all photos");
        return repository.findAll();
    }

    public Photo findById(String id) {
        log.info("* Retrieving file with id {}", id);
        Optional<Photo> optional = repository.findById(id);
        return optional.orElse(null);
    }

    public Photo store(MultipartFile file) throws IOException {
        log.info("* Storing file {}", file.getOriginalFilename());
        Photo photo = new Photo();
        photo.setFilename(file.getOriginalFilename());
        photo.setContentType(file.getContentType());
        photo.setSize(file.getSize());

        DBObject metadata = new BasicDBObject();
        metadata.put("type", file.getContentType());
        metadata.put("title", file.getOriginalFilename());
        metadata.put("size", file.getSize());

        String resourceId = template.store(file.getInputStream(), file.getOriginalFilename(), metadata).toString();

        photo.setResourceId(resourceId);

        return repository.save(photo);
    }

    public byte[] view(String id) throws IOException {
        byte[] data = null;
        Optional<Photo> optional = repository.findById(id);
        if (optional.isPresent()) {
            GridFSFile photo = template.findOne(new Query(Criteria.where("_id").is(optional.get().getResourceId())));
            if (photo != null) {
                data = template.getResource(photo).getInputStream().readAllBytes();
            }
        }
        return data;
    }
}
