package com.project.restaurantly.Mapper.restaurant;

import com.project.restaurantly.Entity.restaurant.Branches;
import com.project.restaurantly.Entity.restaurant.Floors;
import com.project.restaurantly.Entity.restaurant.Locations;
import com.project.restaurantly.Entity.restaurant.Rooms;
import com.project.restaurantly.Entity.restaurant.Tables;
import com.project.restaurantly.dto.request.restaurant.TablesRequest;
import com.project.restaurantly.dto.response.restaurant.BranchesResponse;
import com.project.restaurantly.dto.response.restaurant.FloorsResponse;
import com.project.restaurantly.dto.response.restaurant.LocationsResponse;
import com.project.restaurantly.dto.response.restaurant.RoomsResponse;
import com.project.restaurantly.dto.response.restaurant.TablesResponse;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.3 (Oracle Corporation)"
)
@Component
public class TablesMapperImpl implements TablesMapper {

    @Override
    public Tables toTables(TablesRequest request) {
        if ( request == null ) {
            return null;
        }

        Tables.TablesBuilder tables = Tables.builder();

        tables.table_number( request.getTable_number() );
        tables.seating_capacity( request.getSeating_capacity() );
        tables.create_at( request.getCreate_at() );
        tables.update_at( request.getUpdate_at() );
        tables.status( request.getStatus() );

        return tables.build();
    }

    @Override
    public TablesResponse toTablesResponse(Tables tables) {
        if ( tables == null ) {
            return null;
        }

        TablesResponse.TablesResponseBuilder tablesResponse = TablesResponse.builder();

        tablesResponse.id( tables.getId() );
        tablesResponse.rooms( roomsToRoomsResponse( tables.getRooms() ) );
        tablesResponse.table_number( tables.getTable_number() );
        tablesResponse.seating_capacity( tables.getSeating_capacity() );
        tablesResponse.create_at( tables.getCreate_at() );
        tablesResponse.update_at( tables.getUpdate_at() );
        tablesResponse.status( tables.getStatus() );

        return tablesResponse.build();
    }

    @Override
    public void updateTables(Tables tables, TablesRequest request) {
        if ( request == null ) {
            return;
        }

        tables.setTable_number( request.getTable_number() );
        tables.setSeating_capacity( request.getSeating_capacity() );
        tables.setCreate_at( request.getCreate_at() );
        tables.setUpdate_at( request.getUpdate_at() );
        tables.setStatus( request.getStatus() );
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

    protected RoomsResponse roomsToRoomsResponse(Rooms rooms) {
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
}
