package com.desafios.backendbr.pointsofinterest;

import com.desafios.backendbr.pointsofinterest.infrastructure.entities.PointOfInterestEntity;
import com.desafios.backendbr.pointsofinterest.infrastructure.repositories.PointOfInterestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class PointsofinterestApplication implements CommandLineRunner {

    @Autowired
    private PointOfInterestRepository pointOfInterestRepository;

    public static void main(String[] args) {
        SpringApplication.run(PointsofinterestApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        var lanchonetePOI = poiBuilder("Lanchonete", 27, 12);
        var postoPOI = poiBuilder("Posto", 31, 18);
        var joalheriaPOI = poiBuilder("Joalheria", 15, 12);
        var floriculturaPOI = poiBuilder("Floricultura", 19, 21);
        var pubPOI = poiBuilder("Pub", 12, 8);
        var supermercadoPOI = poiBuilder("Supermercado", 23, 6);
        var churrascariaPOI = poiBuilder("Churrascaria", 28, 2);
        pointOfInterestRepository.saveAll(List.of(lanchonetePOI, postoPOI, joalheriaPOI, floriculturaPOI, pubPOI, supermercadoPOI, churrascariaPOI));
    }

    private PointOfInterestEntity poiBuilder(String name, Integer x, Integer y) {
        var poi = new PointOfInterestEntity();
        poi.setName(name);
        poi.setX(x);
        poi.setY(y);
        return poi;
    }
}
