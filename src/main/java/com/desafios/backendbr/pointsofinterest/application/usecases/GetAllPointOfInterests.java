package com.desafios.backendbr.pointsofinterest.application.usecases;

import com.desafios.backendbr.pointsofinterest.application.models.PointOfInterest;
import com.desafios.backendbr.pointsofinterest.application.ports.PointOfInterestPortDataSourcePort;

import java.util.Set;

public class GetAllPointOfInterests {

    private PointOfInterestPortDataSourcePort pointOfInterestPortDataSourcePort;

    public GetAllPointOfInterests(PointOfInterestPortDataSourcePort pointOfInterestPortDataSourcePort) {
        this.pointOfInterestPortDataSourcePort = pointOfInterestPortDataSourcePort;
    }

    public Set<PointOfInterest> execute() {
        return pointOfInterestPortDataSourcePort.getAllPointOfInterests();
    }
}
