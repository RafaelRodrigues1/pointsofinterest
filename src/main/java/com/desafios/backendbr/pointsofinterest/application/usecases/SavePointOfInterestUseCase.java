package com.desafios.backendbr.pointsofinterest.application.usecases;

import com.desafios.backendbr.pointsofinterest.application.models.PointOfInterest;
import com.desafios.backendbr.pointsofinterest.application.ports.PointOfInterestPortDataSourcePort;

public class SavePointOfInterestUseCase {

    private PointOfInterestPortDataSourcePort pointOfInterestPortDataSourcePort;

    public SavePointOfInterestUseCase(PointOfInterestPortDataSourcePort pointOfInterestPortDataSourcePort) {
        this.pointOfInterestPortDataSourcePort = pointOfInterestPortDataSourcePort;
    }

    public void executar(PointOfInterest pointOfInterest) {
        pointOfInterestPortDataSourcePort.save(pointOfInterest);
    }
}
