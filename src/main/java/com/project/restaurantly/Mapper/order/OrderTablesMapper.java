package com.project.restaurantly.Mapper.order;

import com.project.restaurantly.Entity.order.OrderTables;
import com.project.restaurantly.dto.request.order.OrderTablesRequest;
import com.project.restaurantly.dto.response.order.OrderTablesResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface OrderTablesMapper {
    OrderTables toOrderTables(OrderTablesRequest request);

    OrderTablesResponse toOrderTablesResponse(OrderTables orderTables);

    void updateOrderTables(@MappingTarget OrderTables orderTables, OrderTablesRequest request);
}
