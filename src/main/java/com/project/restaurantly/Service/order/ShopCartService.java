package com.project.restaurantly.Service.order;

import com.project.restaurantly.Entity.PageCustom;
import com.project.restaurantly.Entity.order.ShopCart;
import com.project.restaurantly.Entity.products.Product;
import com.project.restaurantly.Exception.AppException;
import com.project.restaurantly.Exception.ErrorCode;
import com.project.restaurantly.Mapper.order.ShopCartMapper;
import com.project.restaurantly.dto.request.order.ShopCartRequest;
import com.project.restaurantly.dto.response.order.ShopCartResponse;
import com.project.restaurantly.repository.order.ShopCartRepository;
import com.project.restaurantly.repository.products.ProductRepository;
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
public class ShopCartService {
    ShopCartRepository cartRepository;
    ProductRepository productRepository;
    ShopCartMapper cartMapper;

    public ShopCartResponse create(ShopCartRequest request) {
        ShopCart cart = cartMapper.toCart(request);

        int countProduct = cartRepository.totalCartByUerId(request.getUser_id(), 1);
        if(countProduct >= 100) throw new AppException(ErrorCode.MAX_PRODUCT_LIMIT, 100);

        Product product = productRepository.findById(request.getProduct_id())
                .orElseThrow(() -> new AppException(ErrorCode.PRODUCTS_FOOD_NOT_EXISTED));

        ShopCart cartRequest = cartRepository.findByUserIdAndProductId(request.getUser_id(), request.getProduct_id());
        if (cartRequest == null) {
            cart.setProduct(product);
        } else {
            if (cartRequest.getStatus() == 0) {
                cartRequest.setQuantity(request.getQuantity());
                cartRequest.setStatus(1);
            } else {
                cartRequest.setQuantity(cartRequest.getQuantity() + request.getQuantity());
            }
            return cartMapper.toCartResponse(cartRepository.save(cartRequest));
        }

        return cartMapper.toCartResponse(cartRepository.save(cart));
    }

    public List<ShopCartResponse> getAll(int status) {
        var permission = cartRepository.findByStt(status);
        return permission.stream().map(cartMapper::toCartResponse).toList();
    }

    public List<ShopCartResponse> searchAll(long id, int pageNumber, int pageSize, int status, String sort, String desc) {
        Sort sortDirection = (sort != null && !sort.isEmpty())
                ? Sort.by((desc.equals("desc") ? Sort.Direction.DESC : Sort.Direction.ASC), sort)
                : Sort.unsorted();
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize, sortDirection);
        return cartRepository.findByName(id, pageable, status)
                .stream()
                .map(cartMapper::toCartResponse)
                .toList();
    }

    public PageCustom getPagination(int pageNumber, int size, long id, int status) {
        Pageable pageable = PageRequest.of(pageNumber - 1, size);
        Page<ShopCart> page = cartRepository.findByName(id, pageable, status);
        return PageCustom.builder()
                .totalPages(String.valueOf(page.getTotalPages()))
                .totalItems(String.valueOf(page.getTotalElements()))
                .totalItemsPerPage(String.valueOf(page.getNumberOfElements()))
                .currentPage(String.valueOf(pageNumber))
                .build();
    }

    public ShopCartResponse update(ShopCartRequest request, long id) {
        ShopCart cart = cartRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.CART_PRODUCT_NOT_EXISTED));

        cartMapper.updateCart(cart, request);

        return cartMapper.toCartResponse(cartRepository.save(cart));
    }

    public ShopCartResponse updateQuantity(int quantity, long id) {
        ShopCart cart = cartRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.CART_PRODUCT_NOT_EXISTED));

        cart.setQuantity(quantity);

        return cartMapper.toCartResponse(cartRepository.save(cart));
    }

    public void delete(List<Long> ids) {
        List<ShopCart> carts = cartRepository.findAllById(ids);
        if (carts.isEmpty()) {
            throw new AppException(ErrorCode.MENU_NOT_EXISTED);
        }

        for (ShopCart cart : carts) {
            cart.setStatus(0);
        }
        cartRepository.saveAll(carts);
    }
}
