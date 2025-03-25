package com.project.restaurantly.Mapper.restaurant;

import com.project.restaurantly.Entity.restaurant.Branches;
import com.project.restaurantly.Entity.restaurant.Floors;
import com.project.restaurantly.Entity.restaurant.Locations;
import com.project.restaurantly.dto.request.restaurant.FloorsRequest;
import com.project.restaurantly.dto.response.restaurant.BranchesResponse;
import com.project.restaurantly.dto.response.restaurant.FloorsResponse;
import com.project.restaurantly.dto.response.restaurant.LocationsResponse;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.3 (Oracle Corporation)"
)
@Component
public class FloorsMapperImpl implements FloorsMapper {

    @Override
    public Floors toFloors(FloorsRequest request) {
        if ( request == null ) {
            return null;
        }

        Floors.FloorsBuilder floors = Floors.builder();

        floors.name( request.getName() );
        floors.floor_number( request.getFloor_number() );
        floors.create_at( request.getCreate_at() );
        floors.update_at( request.getUpdate_at() );
        floors.status( request.getStatus() );

        return floors.build();
    }

    @Override
    public FloorsResponse toFloorsResponse(Floors floors) {
        if ( floors == null ) {
            return null;
        }

        FloorsResponse.FloorsResponseBuilder floorsResponse = FloorsResponse.builder();

        floorsResponse.id( floors.getId() );
        floorsResponse.name( floors.getName() );
        floorsResponse.branches( branchesToBranchesResponse( floors.getBranches() ) );
        floorsResponse.floor_number( floors.getFloor_number() );
        floorsResponse.create_at( floors.getCreate_at() );
        floorsResponse.update_at( floors.getUpdate_at() );
        floorsResponse.status( floors.getStatus() );

        return floorsResponse.build();
    }

    @Override
    public void updateFloors(Floors floors, FloorsRequest request) {
        if ( request == null ) {
            return;
        }

        floors.setName( request.getName() );
        floors.setFloor_number( request.getFloor_number() );
        floors.setCreate_at( request.getCreate_at() );
        floors.setUpdate_at( request.getUpdate_at() );
        floors.setStatus( request.getStatus() );
    }

    protected LocationsResponse locationsToLocationsResponse(Locations locations) {
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

    protected BranchesResponse branchesToBranchesResponse(Branches branches) {
        if ( branches == null ) {
            return null;
        }

        BranchesResponse.BranchesResponseBuilder branchesResponse = BranchesResponse.builder();

        branchesResponse.id( branches.getId() );
        branchesResponse.locations( locationsToLocationsResponse( branches.getLocations() ) );
        branchesResponse.branch_name( branches.getBranch_name() );
        branchesResponse.address( branches.getAddress() );
        branchesResponse.create_at( branches.getCreate_at() );
        branchesResponse.update_at( branches.getUpdate_at() );
        branchesResponse.status( branches.getStatus() );

        return branchesResponse.build();
    }
}
