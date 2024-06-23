package com.desafios.backendbr.pointsofinterest.application.usecases;

import com.desafios.backendbr.pointsofinterest.application.models.PointOfInterest;
import com.desafios.backendbr.pointsofinterest.application.ports.PointOfInterestDataSourcePort;

import java.util.Set;

public class GetAllPointOfInterests {

    private PointOfInterestDataSourcePort pointOfInterestDataSourcePort;

    public GetAllPointOfInterests(PointOfInterestDataSourcePort pointOfInterestDataSourcePort) {
        this.pointOfInterestDataSourcePort = pointOfInterestDataSourcePort;
    }

    public Set<PointOfInterest> execute() {
        return pointOfInterestDataSourcePort.getAllPointOfInterests();
    }
}
