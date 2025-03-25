package com.project.restaurantly.Mapper.restaurant;

import com.project.restaurantly.Entity.restaurant.Locations;
import com.project.restaurantly.dto.request.restaurant.LocationsRequest;
import com.project.restaurantly.dto.response.restaurant.LocationsResponse;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.3 (Oracle Corporation)"
)
@Component
public class LocationsMapperImpl implements LocationsMapper {

    @Override
    public Locations toLocations(LocationsRequest request) {
        if ( request == null ) {
            return null;
        }

        Locations.LocationsBuilder locations = Locations.builder();

        locations.name( request.getName() );
        locations.address( request.getAddress() );
        locations.city( request.getCity() );
        locations.create_at( request.getCreate_at() );
        locations.update_at( request.getUpdate_at() );
        locations.status( request.getStatus() );

        return locations.build();
    }

    @Override
    public LocationsResponse toLocationsResponse(Locations locations) {
        if ( locations == null ) {
            return null;
        }

        LocationsResponse.LocationsResponseBuilder locationsResponse = LocationsResponse.builder();

        locationsResponse.id( locations.getId() );
        locationsResponse.name( locations.getName() );
        locationsResponse.address( locations.getAddress() );
        locationsResponse.city( locations.getCity() );
        locationsResponse.create_at( locations.getCreate_at() );
        locationsResponse.update_at( locations.getUpdate_at() );
        locationsResponse.status( locations.getStatus() );

        return locationsResponse.build();
    }

    @Override
    public void updateLocations(Locations locations, LocationsRequest request) {
        if ( request == null ) {
            return;
        }

        locations.setName( request.getName() );
        locations.setAddress( request.getAddress() );
        locations.setCity( request.getCity() );
        locations.setCreate_at( request.getCreate_at() );
        locations.setUpdate_at( request.getUpdate_at() );
        locations.setStatus( request.getStatus() );
    }
}
