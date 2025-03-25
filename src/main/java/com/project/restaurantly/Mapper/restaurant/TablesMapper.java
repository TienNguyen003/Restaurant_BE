package com.project.restaurantly.Mapper.restaurant;

import com.project.restaurantly.Entity.restaurant.Tables;
import com.project.restaurantly.dto.request.restaurant.TablesRequest;
import com.project.restaurantly.dto.response.restaurant.TablesResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface TablesMapper {
    Tables toTables(TablesRequest request);

    TablesResponse toTablesResponse(Tables tables);

    void updateTables(@MappingTarget Tables tables, TablesRequest request);
}
