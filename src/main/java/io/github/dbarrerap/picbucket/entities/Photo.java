package io.github.dbarrerap.picbucket.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@Document(collection = "photos")
public class Photo implements Serializable {
    private static final long serialVersionUUID = 1L;
    @Id
    private String id;
    private String filename;
    private String contentType;
    private Long size;

    private String resourceId;
}
