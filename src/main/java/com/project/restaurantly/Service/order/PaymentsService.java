package com.project.restaurantly.Service.order;

import com.project.restaurantly.Entity.PageCustom;
import com.project.restaurantly.Entity.order.Payments;
import com.project.restaurantly.Exception.AppException;
import com.project.restaurantly.Exception.ErrorCode;
import com.project.restaurantly.Mapper.order.PaymentMapper;
import com.project.restaurantly.dto.request.order.PaymentsRequest;
import com.project.restaurantly.dto.response.order.PaymentsResponse;
import com.project.restaurantly.repository.order.PaymentsRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PaymentsService {
    PaymentsRepository paymentRepository;
    PaymentMapper paymentMapper;

    public PaymentsResponse create(PaymentsRequest request) {
        Payments payment = paymentMapper.toPayments(request);

        return paymentMapper.toPaymentsResponse(paymentRepository.save(payment));
    }

    public List<PaymentsResponse> getAll(int status) {
        var permission = paymentRepository.findByStt(status);
        return permission.stream().map(paymentMapper::toPaymentsResponse).toList();
    }

    public List<PaymentsResponse> searchAll(String name, int pageNumber, int pageSize, int status) {
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
        return paymentRepository.findByName(pageable, status)
                .stream()
                .map(paymentMapper::toPaymentsResponse)
                .toList();
    }

    public PageCustom getPagination(int pageNumber, int size, String name, int status) {
        Pageable pageable = PageRequest.of(pageNumber - 1, size);
        Page<Payments> page = paymentRepository.findByName(pageable, status);
        return PageCustom.builder()
                .totalPages(String.valueOf(page.getTotalPages()))
                .totalItems(String.valueOf(page.getTotalElements()))
                .totalItemsPerPage(String.valueOf(page.getNumberOfElements()))
                .currentPage(String.valueOf(pageNumber))
                .build();
    }

    public PaymentsResponse get(long id) {
        return paymentMapper.toPaymentsResponse(paymentRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.MENU_NOT_EXISTED)));
    }

    public PaymentsResponse update(PaymentsRequest request, long id) {
        Payments payment = paymentRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.MENU_NOT_EXISTED));

        paymentMapper.updatePayments(payment, request);

        return paymentMapper.toPaymentsResponse(paymentRepository.save(payment));
    }

    public void delete(long id) {
        Payments payment = paymentRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.MENU_NOT_EXISTED));
        payment.setStatus(0);
        paymentRepository.save(payment);
    }
}
