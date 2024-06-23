package com.desafios.backendbr.pointsofinterest.infrastructure.mappers;

import com.desafios.backendbr.pointsofinterest.application.models.PointOfInterest;
import com.desafios.backendbr.pointsofinterest.infrastructure.dtos.PointOfInterestRequest;
import com.desafios.backendbr.pointsofinterest.infrastructure.entities.PointOfInterestEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PointOfInterestMapper {

    PointOfInterestMapper INSTANCE = Mappers.getMapper(PointOfInterestMapper.class);

    @Mapping(target = "x.value", source = "x")
    @Mapping(target = "y.value", source = "y")
    PointOfInterest entityToModel(PointOfInterestEntity entity);

    @Mapping(target = "x", source = "x.value")
    @Mapping(target = "y", source = "y.value")
    PointOfInterestEntity modelToEntity(PointOfInterest model);

    @Mapping(target = "x.value", source = "x")
    @Mapping(target = "y.value", source = "y")
    PointOfInterest requestoModel(PointOfInterestRequest request);
}
