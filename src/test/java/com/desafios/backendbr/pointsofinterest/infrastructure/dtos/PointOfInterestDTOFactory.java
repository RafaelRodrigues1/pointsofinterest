package com.desafios.backendbr.pointsofinterest.infrastructure.dtos;

import java.util.Set;

public class PointOfInterestDTOFactory {

    public static PointOfInterestDTO createAValidPointOfInterestDTO() {
        return new PointOfInterestDTO("Teste", 30, 40);
    }
}
