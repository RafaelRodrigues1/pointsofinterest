package com.desafios.backendbr.pointsofinterest.infrastructure.adapters;

import com.desafios.backendbr.pointsofinterest.application.models.PointOfInterest;
import com.desafios.backendbr.pointsofinterest.application.ports.PointOfInterestPortDataSourcePort;
import com.desafios.backendbr.pointsofinterest.infrastructure.mappers.PointOfInterestMapper;
import com.desafios.backendbr.pointsofinterest.infrastructure.repositories.PointOfInterestRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PointOfInterestPortRepositoryAdapter implements PointOfInterestPortDataSourcePort {

    private final PointOfInterestRepository pointOfInterestRepository;
    private final PointOfInterestMapper pointOfInterestMapper;

    public PointOfInterestPortRepositoryAdapter(PointOfInterestRepository pointOfInterestRepository, PointOfInterestMapper pointOfInterestMapper) {
        this.pointOfInterestRepository = pointOfInterestRepository;
        this.pointOfInterestMapper = pointOfInterestMapper;
    }

    @Override
    public void save(PointOfInterest poi) {
        // TODO document why this method is empty
    }

    @Override
    public Set<PointOfInterest> searchNearbyPointsOfInterest(Integer distanciaMaxima, Integer x, Integer y) {
        return Set.of();
    }
}
