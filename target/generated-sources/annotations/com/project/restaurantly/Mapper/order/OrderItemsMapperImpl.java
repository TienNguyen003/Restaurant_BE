package com.project.restaurantly.Mapper.order;

import com.project.restaurantly.Entity.order.OrderItems;
import com.project.restaurantly.Entity.order.OrderTables;
import com.project.restaurantly.Entity.order.Orders;
import com.project.restaurantly.dto.request.order.OrderItemsRequest;
import com.project.restaurantly.dto.response.order.OrderItemsResponse;
import com.project.restaurantly.dto.response.order.OrderTablesResponse;
import com.project.restaurantly.dto.response.order.OrdersResponse;
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

        orderItems.product( request.getProduct() );
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

        orderItemsResponse.id( orderItems.getId() );
        orderItemsResponse.orders( ordersToOrdersResponse( orderItems.getOrders() ) );
        orderItemsResponse.ordersTables( orderTablesToOrderTablesResponse( orderItems.getOrdersTables() ) );
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

        orderItems.setProduct( request.getProduct() );
        orderItems.setQuantity( request.getQuantity() );
        orderItems.setCreate_at( request.getCreate_at() );
        orderItems.setStatus( request.getStatus() );
    }

    protected OrdersResponse ordersToOrdersResponse(Orders orders) {
        if ( orders == null ) {
            return null;
        }

        OrdersResponse.OrdersResponseBuilder ordersResponse = OrdersResponse.builder();

        ordersResponse.id( orders.getId() );
        ordersResponse.user_id( orders.getUser_id() );
        ordersResponse.total_amount( orders.getTotal_amount() );
        ordersResponse.state( orders.getState() );
        ordersResponse.create_at( orders.getCreate_at() );
        ordersResponse.update_at( orders.getUpdate_at() );
        ordersResponse.status( orders.getStatus() );

        return ordersResponse.build();
    }

    protected OrderTablesResponse orderTablesToOrderTablesResponse(OrderTables orderTables) {
        if ( orderTables == null ) {
            return null;
        }

        OrderTablesResponse.OrderTablesResponseBuilder orderTablesResponse = OrderTablesResponse.builder();

        orderTablesResponse.id( orderTables.getId() );
        orderTablesResponse.user_id( orderTables.getUser_id() );
        orderTablesResponse.amount( orderTables.getAmount() );
        orderTablesResponse.state( orderTables.getState() );
        orderTablesResponse.special_requests( orderTables.getSpecial_requests() );
        orderTablesResponse.order_type( orderTables.getOrder_type() );
        orderTablesResponse.entity_id( orderTables.getEntity_id() );
        orderTablesResponse.number_of_guests( orderTables.getNumber_of_guests() );
        orderTablesResponse.order_date( orderTables.getOrder_date() );
        orderTablesResponse.reservation_time( orderTables.getReservation_time() );
        orderTablesResponse.create_at( orderTables.getCreate_at() );
        orderTablesResponse.update_at( orderTables.getUpdate_at() );
        orderTablesResponse.status( orderTables.getStatus() );

        return orderTablesResponse.build();
    }
}
