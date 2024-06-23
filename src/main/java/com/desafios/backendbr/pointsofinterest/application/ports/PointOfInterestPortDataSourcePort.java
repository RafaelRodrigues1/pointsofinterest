package com.desafios.backendbr.pointsofinterest.application.ports;

import com.desafios.backendbr.pointsofinterest.application.models.PointOfInterest;

import java.util.Set;

public interface PointOfInterestPortDataSourcePort {

    void save(PointOfInterest poi);
    Set<PointOfInterest> getAllPointOfInterests();
    Set<PointOfInterest> searchNearbyPointsOfInterest(Integer distanciaMaxima, Integer x, Integer y);
}
