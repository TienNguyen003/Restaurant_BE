package com.project.restaurantly.Service.order;

import com.project.restaurantly.Entity.PageCustom;
import com.project.restaurantly.Entity.order.OrderItems;
import com.project.restaurantly.Exception.AppException;
import com.project.restaurantly.Exception.ErrorCode;
import com.project.restaurantly.Mapper.order.OrderItemsMapper;
import com.project.restaurantly.dto.request.order.OrderItemsRequest;
import com.project.restaurantly.dto.response.order.OrderItemsResponse;
import com.project.restaurantly.repository.order.OrderItemsRepository;
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
public class OrderItemsService {
    OrderItemsRepository itemRepository;
    OrderItemsMapper itemMapper;

    public OrderItemsResponse create(OrderItemsRequest request) {
        OrderItems orderItems = itemMapper.toOrderItems(request);

        return itemMapper.toOrderItemsResponse(itemRepository.save(orderItems));
    }

    public List<OrderItemsResponse> getAll(int status) {
        var permission = itemRepository.findByStt(status);
        return permission.stream().map(itemMapper::toOrderItemsResponse).toList();
    }

    public List<OrderItemsResponse> searchAll(String name, int pageNumber, int pageSize, int status) {
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
        return itemRepository.findByName(pageable, status)
                .stream()
                .map(itemMapper::toOrderItemsResponse)
                .toList();
    }

    public PageCustom getPagination(int pageNumber, int size, String name, int status) {
        Pageable pageable = PageRequest.of(pageNumber - 1, size);
        Page<OrderItems> page = itemRepository.findByName(pageable, status);
        return PageCustom.builder()
                .totalPages(String.valueOf(page.getTotalPages()))
                .totalItems(String.valueOf(page.getTotalElements()))
                .totalItemsPerPage(String.valueOf(page.getNumberOfElements()))
                .currentPage(String.valueOf(pageNumber))
                .build();
    }

    public OrderItemsResponse get(Long id) {
        return itemMapper.toOrderItemsResponse(itemRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.MENU_NOT_EXISTED)));
    }

    public OrderItemsResponse update(OrderItemsRequest request, Long id) {
        OrderItems orderItems = itemRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.MENU_NOT_EXISTED));

        itemMapper.updateOrderItems(orderItems, request);

        return itemMapper.toOrderItemsResponse(itemRepository.save(orderItems));
    }

    public void delete(Long id) {
        OrderItems orderItems = itemRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.MENU_NOT_EXISTED));
        orderItems.setStatus(0);
        itemRepository.save(orderItems);
    }
}
