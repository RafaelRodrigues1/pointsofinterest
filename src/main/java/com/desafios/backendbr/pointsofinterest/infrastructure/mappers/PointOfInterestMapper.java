package com.desafios.backendbr.pointsofinterest.infrastructure.mappers;

import com.desafios.backendbr.pointsofinterest.application.models.PointOfInterest;
import com.desafios.backendbr.pointsofinterest.infrastructure.entities.PointOfInterestEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface PointOfInterestMapper {

    @Mapping(target = "x.value", source = "x")
    @Mapping(target = "y.value", source = "y")
    PointOfInterest entityToModel(PointOfInterestEntity entity);

    @Mapping(target = "x", source = "x.value")
    @Mapping(target = "y", source = "y.value")
    PointOfInterestEntity modelToEntity(PointOfInterest model);
}
