package com.project.restaurantly.Mapper.order;

import com.project.restaurantly.Entity.order.Orders;
import com.project.restaurantly.dto.request.order.OrdersRequest;
import com.project.restaurantly.dto.response.order.OrdersResponse;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.3 (Oracle Corporation)"
)
@Component
public class OrdersMapperImpl implements OrdersMapper {

    @Override
    public Orders toOrders(OrdersRequest request) {
        if ( request == null ) {
            return null;
        }

        Orders.OrdersBuilder orders = Orders.builder();

        orders.user_id( request.getUser_id() );
        orders.total_amount( request.getTotal_amount() );
        orders.state( request.getState() );
        orders.create_at( request.getCreate_at() );
        orders.update_at( request.getUpdate_at() );
        orders.status( request.getStatus() );

        return orders.build();
    }

    @Override
    public OrdersResponse toOrdersResponse(Orders orders) {
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

    @Override
    public void updateOrders(Orders orders, OrdersRequest request) {
        if ( request == null ) {
            return;
        }

        orders.setUser_id( request.getUser_id() );
        orders.setTotal_amount( request.getTotal_amount() );
        orders.setState( request.getState() );
        orders.setCreate_at( request.getCreate_at() );
        orders.setUpdate_at( request.getUpdate_at() );
        orders.setStatus( request.getStatus() );
    }
}
