package com.example.demomongodb.repositories;

import com.example.demomongodb.entities.Sport;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SportRepository extends MongoRepository<Sport,String> {
}
