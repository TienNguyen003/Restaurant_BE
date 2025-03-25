package com.project.restaurantly.Mapper.restaurant;

import com.project.restaurantly.Entity.restaurant.Branches;
import com.project.restaurantly.Entity.restaurant.Floors;
import com.project.restaurantly.Entity.restaurant.Locations;
import com.project.restaurantly.Entity.restaurant.Rooms;
import com.project.restaurantly.dto.request.restaurant.RoomsRequest;
import com.project.restaurantly.dto.response.restaurant.BranchesResponse;
import com.project.restaurantly.dto.response.restaurant.FloorsResponse;
import com.project.restaurantly.dto.response.restaurant.LocationsResponse;
import com.project.restaurantly.dto.response.restaurant.RoomsResponse;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.3 (Oracle Corporation)"
)
@Component
public class RoomsMapperImpl implements RoomsMapper {

    @Override
    public Rooms toRooms(RoomsRequest request) {
        if ( request == null ) {
            return null;
        }

        Rooms.RoomsBuilder rooms = Rooms.builder();

        rooms.room_number( request.getRoom_number() );
        rooms.room_name( request.getRoom_name() );
        rooms.create_at( request.getCreate_at() );
        rooms.update_at( request.getUpdate_at() );
        rooms.status( request.getStatus() );

        return rooms.build();
    }

    @Override
    public RoomsResponse toRoomsResponse(Rooms rooms) {
        if ( rooms == null ) {
            return null;
        }

        RoomsResponse.RoomsResponseBuilder roomsResponse = RoomsResponse.builder();

        roomsResponse.id( rooms.getId() );
        roomsResponse.floors( floorsToFloorsResponse( rooms.getFloors() ) );
        roomsResponse.room_number( rooms.getRoom_number() );
        roomsResponse.room_name( rooms.getRoom_name() );
        roomsResponse.category( rooms.getCategory() );
        roomsResponse.create_at( rooms.getCreate_at() );
        roomsResponse.update_at( rooms.getUpdate_at() );
        roomsResponse.status( rooms.getStatus() );

        return roomsResponse.build();
    }

    @Override
    public void updateRooms(Rooms rooms, RoomsRequest request) {
        if ( request == null ) {
            return;
        }

        rooms.setRoom_number( request.getRoom_number() );
        rooms.setRoom_name( request.getRoom_name() );
        rooms.setCreate_at( request.getCreate_at() );
        rooms.setUpdate_at( request.getUpdate_at() );
        rooms.setStatus( request.getStatus() );
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

    protected FloorsResponse floorsToFloorsResponse(Floors floors) {
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
}
