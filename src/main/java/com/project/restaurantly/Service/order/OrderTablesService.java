package com.project.restaurantly.Service.order;

import com.project.restaurantly.Entity.PageCustom;
import com.project.restaurantly.Entity.order.OrderTables;
import com.project.restaurantly.Exception.AppException;
import com.project.restaurantly.Exception.ErrorCode;
import com.project.restaurantly.Mapper.order.OrderTablesMapper;
import com.project.restaurantly.dto.request.order.OrderTablesRequest;
import com.project.restaurantly.dto.response.order.OrderTablesResponse;
import com.project.restaurantly.repository.order.OrderTablesRepository;
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
public class OrderTablesService {
    OrderTablesRepository orderRepository;
    OrderTablesMapper orderMapper;

    public OrderTablesResponse create(OrderTablesRequest request) {
        OrderTables tables = orderMapper.toOrderTables(request);

        return orderMapper.toOrderTablesResponse(orderRepository.save(tables));
    }

    public List<OrderTablesResponse> getAll(int status) {
        var permission = orderRepository.findByStt(status);
        return permission.stream().map(orderMapper::toOrderTablesResponse).toList();
    }

    public List<OrderTablesResponse> searchAll(String name, int pageNumber, int pageSize, int status) {
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
        return orderRepository.findByName(pageable, status)
                .stream()
                .map(orderMapper::toOrderTablesResponse)
                .toList();
    }

    public PageCustom getPagination(int pageNumber, int size, String name, int status) {
        Pageable pageable = PageRequest.of(pageNumber - 1, size);
        Page<OrderTables> page = orderRepository.findByName(pageable, status);
        return PageCustom.builder()
                .totalPages(String.valueOf(page.getTotalPages()))
                .totalItems(String.valueOf(page.getTotalElements()))
                .totalItemsPerPage(String.valueOf(page.getNumberOfElements()))
                .currentPage(String.valueOf(pageNumber))
                .build();
    }

    public OrderTablesResponse get(long id) {
        return orderMapper.toOrderTablesResponse(orderRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.MENU_NOT_EXISTED)));
    }

    public OrderTablesResponse update(OrderTablesRequest request, long id) {
        OrderTables menu = orderRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.MENU_NOT_EXISTED));

        orderMapper.updateOrderTables(menu, request);

        return orderMapper.toOrderTablesResponse(orderRepository.save(menu));
    }

    public void delete(long id) {
        OrderTables tables = orderRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.MENU_NOT_EXISTED));
        tables.setStatus(0);
        orderRepository.save(tables);
    }
}
