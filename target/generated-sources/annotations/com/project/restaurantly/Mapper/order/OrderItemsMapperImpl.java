package com.project.restaurantly.Mapper.order;

import com.project.restaurantly.Entity.order.OrderItems;
import com.project.restaurantly.Entity.order.OrderTables;
import com.project.restaurantly.Entity.order.Orders;
import com.project.restaurantly.dto.request.order.OrderItemsRequest;
import com.project.restaurantly.dto.response.order.OrderItemsResponse;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.3 (Oracle Corporation)"
)
@Component
public class OrderItemsMapperImpl implements OrderItemsMapper {

    @Override
    public OrderItems toOrderItems(OrderItemsRequest request) {
        if ( request == null ) {
            return null;
        }

        OrderItems.OrderItemsBuilder orderItems = OrderItems.builder();

        orderItems.quantity( request.getQuantity() );
        orderItems.create_at( request.getCreate_at() );
        orderItems.status( request.getStatus() );

        return orderItems.build();
    }

    @Override
    public OrderItemsResponse toOrderItemsResponse(OrderItems orderItems) {
        if ( orderItems == null ) {
            return null;
        }

        OrderItemsResponse.OrderItemsResponseBuilder orderItemsResponse = OrderItemsResponse.builder();

        orderItemsResponse.orders_id( orderItemsOrdersId( orderItems ) );
        orderItemsResponse.ordersTables_id( orderItemsOrdersTablesId( orderItems ) );
        orderItemsResponse.id( orderItems.getId() );
        orderItemsResponse.product( orderItems.getProduct() );
        orderItemsResponse.quantity( orderItems.getQuantity() );
        orderItemsResponse.create_at( orderItems.getCreate_at() );
        orderItemsResponse.status( orderItems.getStatus() );

        return orderItemsResponse.build();
    }

    @Override
    public void updateOrderItems(OrderItems orderItems, OrderItemsRequest request) {
        if ( request == null ) {
            return;
        }

        orderItems.setQuantity( request.getQuantity() );
        orderItems.setCreate_at( request.getCreate_at() );
        orderItems.setStatus( request.getStatus() );
    }

    private long orderItemsOrdersId(OrderItems orderItems) {
        if ( orderItems == null ) {
            return 0L;
        }
        Orders orders = orderItems.getOrders();
        if ( orders == null ) {
            return 0L;
        }
        long id = orders.getId();
        return id;
    }

    private long orderItemsOrdersTablesId(OrderItems orderItems) {
        if ( orderItems == null ) {
            return 0L;
        }
        OrderTables ordersTables = orderItems.getOrdersTables();
        if ( ordersTables == null ) {
            return 0L;
        }
        long id = ordersTables.getId();
        return id;
    }
}
