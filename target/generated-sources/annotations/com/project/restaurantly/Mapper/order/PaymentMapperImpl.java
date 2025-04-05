package com.project.restaurantly.Mapper.order;

import com.project.restaurantly.Entity.order.OrderTables;
import com.project.restaurantly.Entity.order.Orders;
import com.project.restaurantly.Entity.order.Payments;
import com.project.restaurantly.dto.request.order.PaymentsRequest;
import com.project.restaurantly.dto.response.order.OrderTablesResponse;
import com.project.restaurantly.dto.response.order.OrdersResponse;
import com.project.restaurantly.dto.response.order.PaymentsResponse;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.3 (Oracle Corporation)"
)
@Component
public class PaymentMapperImpl implements PaymentMapper {

    @Override
    public Payments toPayments(PaymentsRequest request) {
        if ( request == null ) {
            return null;
        }

        Payments.PaymentsBuilder payments = Payments.builder();

        payments.payment_method( request.getPayment_method() );
        payments.payment_status( request.getPayment_status() );
        payments.create_at( request.getCreate_at() );
        payments.status( request.getStatus() );

        return payments.build();
    }

    @Override
    public PaymentsResponse toPaymentsResponse(Payments payments) {
        if ( payments == null ) {
            return null;
        }

        PaymentsResponse.PaymentsResponseBuilder paymentsResponse = PaymentsResponse.builder();

        paymentsResponse.id( payments.getId() );
        paymentsResponse.orders( ordersToOrdersResponse( payments.getOrders() ) );
        paymentsResponse.ordersTables( orderTablesToOrderTablesResponse( payments.getOrdersTables() ) );
        paymentsResponse.payment_method( payments.getPayment_method() );
        paymentsResponse.payment_status( payments.getPayment_status() );
        paymentsResponse.create_at( payments.getCreate_at() );
        paymentsResponse.status( payments.getStatus() );

        return paymentsResponse.build();
    }

    @Override
    public void updatePayments(Payments payments, PaymentsRequest request) {
        if ( request == null ) {
            return;
        }

        payments.setPayment_method( request.getPayment_method() );
        payments.setPayment_status( request.getPayment_status() );
        payments.setCreate_at( request.getCreate_at() );
        payments.setStatus( request.getStatus() );
    }

    protected OrdersResponse ordersToOrdersResponse(Orders orders) {
        if ( orders == null ) {
            return null;
        }

        OrdersResponse.OrdersResponseBuilder ordersResponse = OrdersResponse.builder();

        ordersResponse.id( orders.getId() );
        ordersResponse.user_id( orders.getUser_id() );
        ordersResponse.total_amount( orders.getTotal_amount() );
        ordersResponse.fee( orders.getFee() );
        ordersResponse.phone_number( orders.getPhone_number() );
        ordersResponse.name( orders.getName() );
        ordersResponse.address( orders.getAddress() );
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
