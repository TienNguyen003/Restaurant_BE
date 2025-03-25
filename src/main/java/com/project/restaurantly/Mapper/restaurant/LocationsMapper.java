package com.project.restaurantly.Mapper.restaurant;

import com.project.restaurantly.Entity.restaurant.Locations;
import com.project.restaurantly.dto.request.restaurant.LocationsRequest;
import com.project.restaurantly.dto.response.restaurant.LocationsResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface LocationsMapper {
    Locations toLocations(LocationsRequest request);

    LocationsResponse toLocationsResponse(Locations locations);

    void updateLocations(@MappingTarget Locations locations, LocationsRequest request);
}
