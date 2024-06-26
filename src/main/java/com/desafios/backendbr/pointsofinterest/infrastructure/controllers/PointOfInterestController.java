package com.desafios.backendbr.pointsofinterest.infrastructure.controllers;

import com.desafios.backendbr.pointsofinterest.application.ports.PointOfInterestDataSourcePort;
import com.desafios.backendbr.pointsofinterest.application.usecases.GetAllPointOfInterestsUseCase;
import com.desafios.backendbr.pointsofinterest.application.usecases.GetNearbyPointsOfInterestUseCase;
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
    private final GetAllPointOfInterestsUseCase getAllPointOfInterestsUseCase;
    private final GetNearbyPointsOfInterestUseCase getNearbyPointsOfInterestUseCase;

    public PointOfInterestController(PointOfInterestDataSourcePort dataSource) {
        savePointOfInterestUseCase = new SavePointOfInterestUseCase(dataSource);
        getAllPointOfInterestsUseCase = new GetAllPointOfInterestsUseCase(dataSource);
        getNearbyPointsOfInterestUseCase = new GetNearbyPointsOfInterestUseCase(dataSource);
    }

    @PostMapping
    public ResponseEntity<Void> savePointOfInterest(@RequestBody(required = true) PointOfInterestDTO pointOfInterestRequest) {
        savePointOfInterestUseCase.execute(INSTANCE.dtoToModel(pointOfInterestRequest));
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Set<PointOfInterestDTO>> getAllPointOfInterest() {
        return ResponseEntity.ok(getAllPointOfInterestsUseCase.execute()
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
        return ResponseEntity.ok(getNearbyPointsOfInterestUseCase.execute(maxDistance, x, y)
                .stream()
                .map(INSTANCE::modelToDTO)
                .collect(Collectors.toSet())
        );
    }
}
