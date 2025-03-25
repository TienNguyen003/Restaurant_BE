package com.project.restaurantly.Mapper.restaurant;

import com.project.restaurantly.Entity.restaurant.Branches;
import com.project.restaurantly.Entity.restaurant.Locations;
import com.project.restaurantly.dto.request.restaurant.BranchesRequest;
import com.project.restaurantly.dto.response.restaurant.BranchesResponse;
import com.project.restaurantly.dto.response.restaurant.LocationsResponse;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.3 (Oracle Corporation)"
)
@Component
public class BranchesMapperImpl implements BranchesMapper {

    @Override
    public Branches toBranches(BranchesRequest request) {
        if ( request == null ) {
            return null;
        }

        Branches.BranchesBuilder branches = Branches.builder();

        branches.branch_name( request.getBranch_name() );
        branches.address( request.getAddress() );
        branches.create_at( request.getCreate_at() );
        branches.update_at( request.getUpdate_at() );
        branches.status( request.getStatus() );

        return branches.build();
    }

    @Override
    public BranchesResponse toBranchesResponse(Branches branches) {
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

    @Override
    public void updateBranches(Branches branches, BranchesRequest request) {
        if ( request == null ) {
            return;
        }

        branches.setBranch_name( request.getBranch_name() );
        branches.setAddress( request.getAddress() );
        branches.setCreate_at( request.getCreate_at() );
        branches.setUpdate_at( request.getUpdate_at() );
        branches.setStatus( request.getStatus() );
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
}
