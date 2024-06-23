package com.desafios.backendbr.pointsofinterest.infrastructure.repositories;

import com.desafios.backendbr.pointsofinterest.infrastructure.entities.PointOfInterestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.UUID;

@Repository
public interface PointOfInterestRepository extends JpaRepository<PointOfInterestEntity, UUID> {

    @Query(value = """
        select p
        from PointOfInterestEntity p
        where p.x >= :xMin and p.x <= :xMax
            and p.y >= :yMin and p.y <= :yMax
    """)
    Set<PointOfInterestEntity> getNearbyPointsOfInterestByMaxDistance(
            @Param("xMin") Integer xMin,
            @Param("xMax") Integer xMax,
            @Param("yMin") Integer yMin,
            @Param("yMax") Integer yMax
    );
}
