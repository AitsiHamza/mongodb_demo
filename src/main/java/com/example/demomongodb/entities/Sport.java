package com.example.demomongodb.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@AllArgsConstructor @NoArgsConstructor @Data @Builder
@Document(collection = "Sports")
public class Sport {
    @Id
    private String id;

    private String name;
    private String description;

    private List<Championship> championships;
}