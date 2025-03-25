package com.project.restaurantly.Mapper.restaurant;

import com.project.restaurantly.Entity.restaurant.Floors;
import com.project.restaurantly.dto.request.restaurant.FloorsRequest;
import com.project.restaurantly.dto.response.restaurant.FloorsResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface FloorsMapper {
    Floors toFloors(FloorsRequest request);

    FloorsResponse toFloorsResponse(Floors floors);

    void updateFloors(@MappingTarget Floors floors, FloorsRequest request);
}
