package com.desafios.backendbr.pointsofinterest.application.usecases;

import com.desafios.backendbr.pointsofinterest.application.models.PointOfInterest;
import com.desafios.backendbr.pointsofinterest.application.ports.PointOfInterestDataSourcePort;

import java.util.Set;

public class GetNearbyPointsOfInterest {

    private PointOfInterestDataSourcePort pointOfInterestDataSourcePort;

    public GetNearbyPointsOfInterest(PointOfInterestDataSourcePort pointOfInterestDataSourcePort) {
        this.pointOfInterestDataSourcePort = pointOfInterestDataSourcePort;
    }

    public Set<PointOfInterest> execute(Integer maxDistance, Integer x, Integer y) {
        return pointOfInterestDataSourcePort.searchNearbyPointsOfInterest(maxDistance, x, y);
    }
}
