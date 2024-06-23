package com.desafios.backendbr.pointsofinterest.infrastructure.controllers;

import com.desafios.backendbr.pointsofinterest.application.ports.PointOfInterestDataSourcePort;
import com.desafios.backendbr.pointsofinterest.application.usecases.GetAllPointOfInterests;
import com.desafios.backendbr.pointsofinterest.application.usecases.GetNearbyPointsOfInterest;
import com.desafios.backendbr.pointsofinterest.application.usecases.SavePointOfInterestUseCase;
import com.desafios.backendbr.pointsofinterest.infrastructure.dtos.PointOfInterestDTO;
import static com.desafios.backendbr.pointsofinterest.infrastructure.mappers.PointOfInterestMapper.INSTANCE;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("poi")
public class PointOfInterestController {

    private final SavePointOfInterestUseCase savePointOfInterestUseCase;
    private final GetAllPointOfInterests getAllPointOfInterests;
    private final GetNearbyPointsOfInterest getNearbyPointsOfInterest;

    public PointOfInterestController(PointOfInterestDataSourcePort dataSource) {
        savePointOfInterestUseCase = new SavePointOfInterestUseCase(dataSource);
        getAllPointOfInterests = new GetAllPointOfInterests(dataSource);
        getNearbyPointsOfInterest = new GetNearbyPointsOfInterest(dataSource);
    }

    @PostMapping
    public ResponseEntity<Void> savePointOfInterest(@RequestBody(required = true) PointOfInterestDTO pointOfInterestRequest) {
        savePointOfInterestUseCase.execute(INSTANCE.dtoToModel(pointOfInterestRequest));
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Set<PointOfInterestDTO>> getAllPointOfInterest() {
        return ResponseEntity.ok(getAllPointOfInterests.execute()
                .stream()
                .map(INSTANCE::modelToDTO)
                .collect(Collectors.toSet())
        );
    }

    @GetMapping("nearby")
    public ResponseEntity<Set<PointOfInterestDTO>> getPointsOfInterestNearMe(
            @RequestParam(required = true) Integer maxDistance,
            @RequestParam(required = true) Integer x,
            @RequestParam(required = true) Integer y) {
        return ResponseEntity.ok(getNearbyPointsOfInterest.execute(maxDistance, x, y)
                .stream()
                .map(INSTANCE::modelToDTO)
                .collect(Collectors.toSet())
        );
    }
}
