package com.project.restaurantly.Mapper.order;

import com.project.restaurantly.Entity.order.OrderItems;
import com.project.restaurantly.dto.request.order.OrderItemsRequest;
import com.project.restaurantly.dto.response.order.OrderItemsResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface OrderItemsMapper {
    OrderItems toOrderItems(OrderItemsRequest request);

    OrderItemsResponse toOrderItemsResponse(OrderItems orderItems);

    void updateOrderItems(@MappingTarget OrderItems orderItems, OrderItemsRequest request);
}
