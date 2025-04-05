package com.project.restaurantly.Service.order;

import com.project.restaurantly.Entity.PageCustom;
import com.project.restaurantly.Entity.order.Orders;
import com.project.restaurantly.Exception.AppException;
import com.project.restaurantly.Exception.ErrorCode;
import com.project.restaurantly.Mapper.order.OrdersMapper;
import com.project.restaurantly.dto.request.order.OrdersRequest;
import com.project.restaurantly.dto.response.order.OrdersResponse;
import com.project.restaurantly.repository.order.OrdersRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class OrdersService {
    OrdersRepository ordersRepository;
    OrdersMapper orderMapper;

    public OrdersResponse create(OrdersRequest request) {
        Orders orders = orderMapper.toOrders(request);

        return orderMapper.toOrdersResponse(ordersRepository.save(orders));
    }

    public OrdersResponse getAll(long id) {
        return orderMapper.toOrdersResponse(ordersRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.MENU_NOT_EXISTED)));
    }

    public List<OrdersResponse> searchAll(String user_id, int status, int pageNumber, int pageSize, String sort, String desc) {
        Sort sortDirection = (sort != null && !sort.isEmpty())
                ? Sort.by((desc.equals("desc") ? Sort.Direction.DESC : Sort.Direction.ASC), sort)
                : Sort.unsorted();
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize, sortDirection);
        ordersRepository.findByName(pageable, user_id, status);
        return ordersRepository.findByName(pageable, user_id, status)
                .stream()
                .map(orderMapper::toOrdersResponse)
                .toList();
    }

    public PageCustom getPagination(int pageNumber, int size, String user_id, int status) {
        Pageable pageable = PageRequest.of(pageNumber - 1, size);
        Page<Orders> page = ordersRepository.findByName(pageable, user_id, status);
        return PageCustom.builder()
                .totalPages(String.valueOf(page.getTotalPages()))
                .totalItems(String.valueOf(page.getTotalElements()))
                .totalItemsPerPage(String.valueOf(page.getNumberOfElements()))
                .currentPage(String.valueOf(pageNumber))
                .build();
    }

    public OrdersResponse update(OrdersRequest request, long id) {
        Orders orders = ordersRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.MENU_NOT_EXISTED));

        orderMapper.updateOrders(orders, request);

        return orderMapper.toOrdersResponse(ordersRepository.save(orders));
    }

    public void delete(long id) {
        Orders orders = ordersRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.MENU_NOT_EXISTED));
        orders.setStatus(0);
        ordersRepository.save(orders);
    }
}
