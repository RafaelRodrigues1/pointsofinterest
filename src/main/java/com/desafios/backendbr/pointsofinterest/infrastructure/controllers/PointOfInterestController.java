package com.desafios.backendbr.pointsofinterest.infrastructure.controllers;

import com.desafios.backendbr.pointsofinterest.application.models.PointOfInterest;
import com.desafios.backendbr.pointsofinterest.application.ports.PointOfInterestPortDataSourcePort;
import com.desafios.backendbr.pointsofinterest.application.usecases.GetAllPointOfInterests;
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

    public PointOfInterestController(PointOfInterestPortDataSourcePort dataSource) {
        savePointOfInterestUseCase = new SavePointOfInterestUseCase(dataSource);
        getAllPointOfInterests = new GetAllPointOfInterests(dataSource);
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
}
