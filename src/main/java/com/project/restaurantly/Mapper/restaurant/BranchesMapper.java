package com.project.restaurantly.Mapper.restaurant;

import com.project.restaurantly.Entity.restaurant.Branches;
import com.project.restaurantly.dto.request.restaurant.BranchesRequest;
import com.project.restaurantly.dto.response.restaurant.BranchesResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface BranchesMapper {
    Branches toBranches(BranchesRequest request);

    BranchesResponse toBranchesResponse(Branches branches);

    void updateBranches(@MappingTarget Branches branches, BranchesRequest request);
}
