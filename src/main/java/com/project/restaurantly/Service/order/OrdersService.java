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

//    public List<OrdersResponse> create(List<OrdersRequest> requests) {
//        List<Orders> ordersList = requests.stream()
//                .map(orderMapper::toOrders)
//                .collect(Collectors.toList());
//
//        List<Orders> savedOrders = ordersRepository.saveAll(ordersList);
//
//        return savedOrders.stream()
//                .map(orderMapper::toOrdersResponse)
//                .collect(Collectors.toList());
//    }

    public List<OrdersResponse> getAll(int status) {
        var permission = ordersRepository.findByStt(status);
        return permission.stream().map(orderMapper::toOrdersResponse).toList();
    }

    public List<OrdersResponse> searchAll(String name, int pageNumber, int pageSize, int status) {
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
        return ordersRepository.findByName(pageable, status)
                .stream()
                .map(orderMapper::toOrdersResponse)
                .toList();
    }

    public PageCustom getPagination(int pageNumber, int size, String name, int status) {
        Pageable pageable = PageRequest.of(pageNumber - 1, size);
        Page<Orders> page = ordersRepository.findByName(pageable, status);
        return PageCustom.builder()
                .totalPages(String.valueOf(page.getTotalPages()))
                .totalItems(String.valueOf(page.getTotalElements()))
                .totalItemsPerPage(String.valueOf(page.getNumberOfElements()))
                .currentPage(String.valueOf(pageNumber))
                .build();
    }

    public OrdersResponse get(long id) {
        return orderMapper.toOrdersResponse(ordersRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.MENU_NOT_EXISTED)));
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
