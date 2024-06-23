package com.desafios.backendbr.pointsofinterest.application.usecases;

import com.desafios.backendbr.pointsofinterest.application.models.PointOfInterest;
import com.desafios.backendbr.pointsofinterest.application.ports.PointOfInterestDataSourcePort;

public class SavePointOfInterestUseCase {

    private PointOfInterestDataSourcePort pointOfInterestDataSourcePort;

    public SavePointOfInterestUseCase(PointOfInterestDataSourcePort pointOfInterestDataSourcePort) {
        this.pointOfInterestDataSourcePort = pointOfInterestDataSourcePort;
    }

    public void execute(PointOfInterest pointOfInterest) {
        pointOfInterestDataSourcePort.save(pointOfInterest);
    }
}
