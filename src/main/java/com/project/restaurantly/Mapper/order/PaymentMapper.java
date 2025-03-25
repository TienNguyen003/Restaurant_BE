package com.project.restaurantly.Mapper.order;

import com.project.restaurantly.Entity.order.Payments;
import com.project.restaurantly.dto.request.order.PaymentsRequest;
import com.project.restaurantly.dto.response.order.PaymentsResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface PaymentMapper {
    Payments toPayments(PaymentsRequest request);

    PaymentsResponse toPaymentsResponse(Payments payments);

    void updatePayments(@MappingTarget Payments payments, PaymentsRequest request);
}
