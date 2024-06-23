package com.desafios.backendbr.pointsofinterest.infrastructure.adapters;

import com.desafios.backendbr.pointsofinterest.application.models.PointOfInterest;
import com.desafios.backendbr.pointsofinterest.application.ports.PointOfInterestPortDataSourcePort;
import static com.desafios.backendbr.pointsofinterest.infrastructure.mappers.PointOfInterestMapper.INSTANCE;
import com.desafios.backendbr.pointsofinterest.infrastructure.repositories.PointOfInterestRepository;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PointOfInterestPortRepositoryAdapter implements PointOfInterestPortDataSourcePort {

    private final PointOfInterestRepository pointOfInterestRepository;

    public PointOfInterestPortRepositoryAdapter(PointOfInterestRepository pointOfInterestRepository) {
        this.pointOfInterestRepository = pointOfInterestRepository;
    }

    @Override
    public void save(PointOfInterest poi) {
        var entity = INSTANCE.modelToEntity(poi);
        pointOfInterestRepository.save(entity);
    }

    @Override
    public Set<PointOfInterest> searchNearbyPointsOfInterest(Integer distanciaMaxima, Integer x, Integer y) {
        return Set.of();
    }
}
