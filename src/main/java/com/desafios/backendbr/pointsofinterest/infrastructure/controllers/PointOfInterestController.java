package com.desafios.backendbr.pointsofinterest.infrastructure.controllers;

import com.desafios.backendbr.pointsofinterest.application.ports.PointOfInterestPortDataSourcePort;
import com.desafios.backendbr.pointsofinterest.application.usecases.SavePointOfInterestUseCase;
import com.desafios.backendbr.pointsofinterest.infrastructure.dtos.PointOfInterestRequest;
import static com.desafios.backendbr.pointsofinterest.infrastructure.mappers.PointOfInterestMapper.INSTANCE;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("poi")
public class PointOfInterestController {

    private final SavePointOfInterestUseCase savePointOfInterestUseCase;

    public PointOfInterestController(PointOfInterestPortDataSourcePort dataSource) {
        savePointOfInterestUseCase = new SavePointOfInterestUseCase(dataSource);
    }

    @PostMapping
    public ResponseEntity<Void> savePointOfInterest(@RequestBody(required = true) PointOfInterestRequest pointOfInterestRequest) {
        savePointOfInterestUseCase.executar(INSTANCE.requestoModel(pointOfInterestRequest));
        return ResponseEntity.ok().build();
    }
}
