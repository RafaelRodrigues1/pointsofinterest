package com.desafios.backendbr.pointsofinterest.application.models;

public record CartesianPlanePoint(Integer value) {

    public CartesianPlanePoint {
        validate(value);
    }

    private void validate(Integer value) {
        if(value < 0) throw new IllegalArgumentException("point cannot be negative");
    }
}
