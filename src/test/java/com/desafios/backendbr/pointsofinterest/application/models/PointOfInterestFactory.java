package com.desafios.backendbr.pointsofinterest.application.models;


import java.util.Set;

public class PointOfInterestFactory {

    public static Set<PointOfInterest> createASetOfValidPointOfInterest() {
        return Set.of(
                new PointOfInterest("Teste", new CartesianPlanePoint(30), new CartesianPlanePoint(40)),
                new PointOfInterest("Teste2", new CartesianPlanePoint(50), new CartesianPlanePoint(60)),
                new PointOfInterest("Teste3", new CartesianPlanePoint(70), new CartesianPlanePoint(80))
        );
    }
}
