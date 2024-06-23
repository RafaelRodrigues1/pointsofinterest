package com.desafios.backendbr.pointsofinterest.infrastructure.adapters;

import com.desafios.backendbr.pointsofinterest.application.models.PointOfInterest;
import com.desafios.backendbr.pointsofinterest.application.ports.PointOfInterestDataSourcePort;
import static com.desafios.backendbr.pointsofinterest.infrastructure.mappers.PointOfInterestMapper.INSTANCE;
import com.desafios.backendbr.pointsofinterest.infrastructure.repositories.PointOfInterestRepository;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PointOfInterestPortRepositoryAdapter implements PointOfInterestDataSourcePort {

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
    public Set<PointOfInterest> getAllPointOfInterests() {
        return pointOfInterestRepository.findAll().stream().map(INSTANCE::entityToModel).collect(Collectors.toSet());
    }

    @Override
    public Set<PointOfInterest> searchNearbyPointsOfInterest(Integer maxDistance, Integer x, Integer y) {
        var poiEntitySet = pointOfInterestRepository.getNearbyPointsOfInterestByMaxDistance(
                        x - maxDistance, x + maxDistance, y - maxDistance, y + maxDistance);
        return poiEntitySet.stream()
                .filter(entity -> isPointOnRadius(maxDistance, x, y, entity.getX(), entity.getY()))
                .map(INSTANCE::entityToModel)
                .collect(Collectors.toSet());
    }

    private boolean isPointOnRadius(Integer maxDistance, Integer x1, Integer y1, Integer x2, Integer y2) {
        return maxDistance >= Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
    }
}
