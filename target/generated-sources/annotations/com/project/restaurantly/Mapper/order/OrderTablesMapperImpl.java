package com.project.restaurantly.Mapper.order;

import com.project.restaurantly.Entity.order.OrderTables;
import com.project.restaurantly.dto.request.order.OrderTablesRequest;
import com.project.restaurantly.dto.response.order.OrderTablesResponse;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.3 (Oracle Corporation)"
)
@Component
public class OrderTablesMapperImpl implements OrderTablesMapper {

    @Override
    public OrderTables toOrderTables(OrderTablesRequest request) {
        if ( request == null ) {
            return null;
        }

        OrderTables.OrderTablesBuilder orderTables = OrderTables.builder();

        orderTables.user_id( request.getUser_id() );
        orderTables.amount( request.getAmount() );
        orderTables.state( request.getState() );
        orderTables.special_requests( request.getSpecial_requests() );
        orderTables.order_type( request.getOrder_type() );
        orderTables.entity_id( request.getEntity_id() );
        orderTables.number_of_guests( request.getNumber_of_guests() );
        orderTables.order_date( request.getOrder_date() );
        orderTables.reservation_time( request.getReservation_time() );
        orderTables.create_at( request.getCreate_at() );
        orderTables.update_at( request.getUpdate_at() );
        orderTables.status( request.getStatus() );

        return orderTables.build();
    }

    @Override
    public OrderTablesResponse toOrderTablesResponse(OrderTables orderTables) {
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

    @Override
    public void updateOrderTables(OrderTables orderTables, OrderTablesRequest request) {
        if ( request == null ) {
            return;
        }

        orderTables.setUser_id( request.getUser_id() );
        orderTables.setAmount( request.getAmount() );
        orderTables.setState( request.getState() );
        orderTables.setSpecial_requests( request.getSpecial_requests() );
        orderTables.setOrder_type( request.getOrder_type() );
        orderTables.setEntity_id( request.getEntity_id() );
        orderTables.setNumber_of_guests( request.getNumber_of_guests() );
        orderTables.setOrder_date( request.getOrder_date() );
        orderTables.setReservation_time( request.getReservation_time() );
        orderTables.setCreate_at( request.getCreate_at() );
        orderTables.setUpdate_at( request.getUpdate_at() );
        orderTables.setStatus( request.getStatus() );
    }
}
