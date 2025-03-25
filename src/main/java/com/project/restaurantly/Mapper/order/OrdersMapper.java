package com.project.restaurantly.Mapper.order;

import com.project.restaurantly.Entity.order.Orders;
import com.project.restaurantly.dto.request.order.OrdersRequest;
import com.project.restaurantly.dto.response.order.OrdersResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface OrdersMapper {
    Orders toOrders(OrdersRequest request);

    OrdersResponse toOrdersResponse(Orders orders);

    void updateOrders(@MappingTarget Orders orders, OrdersRequest request);
}
