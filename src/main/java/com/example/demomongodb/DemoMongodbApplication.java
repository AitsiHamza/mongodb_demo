package com.example.demomongodb;

import com.example.demomongodb.entities.Championship;
import com.example.demomongodb.entities.Sport;
import com.example.demomongodb.services.SportService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@AllArgsConstructor
@RestController
public class DemoMongodbApplication {
    @Autowired
    private SportService sportService;

     @PostMapping
     public Sport saveSport(){
         List<Championship> championships = new ArrayList<>();
         Championship mondialito = Championship.builder()
                 .id(UUID.randomUUID().toString())
                 .name("Mondialito")
                 .teams(32)
                 .build();
         Championship national = Championship.builder()
                 .id(UUID.randomUUID().toString())
                 .name("National")
                 .teams(12)
                 .build();

         championships.add(mondialito);
         championships.add(national);

         return sportService.saveSport(Sport.builder()
                                 .id(UUID.randomUUID().toString())
                                 .name("Taekwondo")
                                 .description("Originated from korea!")
                                 .championships(championships)
                                 .build()
         );
     }
     @GetMapping
     public List<Sport> sportList(){
         return sportService.getSports();
     }

    public static void main(String[] args) {
        SpringApplication.run(DemoMongodbApplication.class, args);
    }

}
