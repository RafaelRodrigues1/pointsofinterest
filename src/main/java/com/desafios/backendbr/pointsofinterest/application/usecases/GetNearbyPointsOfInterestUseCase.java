package com.desafios.backendbr.pointsofinterest.application.usecases;

import com.desafios.backendbr.pointsofinterest.application.models.PointOfInterest;
import com.desafios.backendbr.pointsofinterest.application.ports.PointOfInterestDataSourcePort;

import java.util.Set;

public class GetNearbyPointsOfInterestUseCase {

    private PointOfInterestDataSourcePort pointOfInterestDataSourcePort;

    public GetNearbyPointsOfInterestUseCase(PointOfInterestDataSourcePort pointOfInterestDataSourcePort) {
        this.pointOfInterestDataSourcePort = pointOfInterestDataSourcePort;
    }

    public Set<PointOfInterest> execute(Integer maxDistance, Integer x, Integer y) {
        return pointOfInterestDataSourcePort.searchNearbyPointsOfInterest(maxDistance, x, y);
    }
}
