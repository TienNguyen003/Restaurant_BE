package com.project.restaurantly.Service.products;

import com.project.restaurantly.Entity.PageCustom;
import com.project.restaurantly.Entity.products.Product;
import com.project.restaurantly.Exception.AppException;
import com.project.restaurantly.Exception.ErrorCode;
import com.project.restaurantly.Mapper.products.ProductMapper;
import com.project.restaurantly.dto.request.products.ProductRequest;
import com.project.restaurantly.dto.response.products.ProductResponse;
import com.project.restaurantly.repository.products.ProductRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductService {
    ProductRepository productRepository;
    ProductMapper productMapper;

    public ProductResponse create(ProductRequest request) {
        Product product = productMapper.toFoods(request);

        productRepository.save(product);

        return productMapper.toFoodsRespone(product);
    }

    public List<ProductResponse> getAll() {
        return productRepository.findAll().stream().map(productMapper::toFoodsRespone).toList();
    }

    public List<ProductResponse> searchAll(int pageNumber, int size, int status) {
        Pageable pageable = PageRequest.of(pageNumber - 1, size);
        return productRepository.findByName(pageable, status)
                .stream()
                .map(productMapper::toFoodsRespone)
                .toList();
    }

    public PageCustom getPagination(int pageNumber, int size, int status) {
        Pageable pageable = PageRequest.of(pageNumber - 1, size);
        Page<Product> page = productRepository.findByName(pageable, status);
        return PageCustom.builder()
                .totalPages(String.valueOf(page.getTotalPages()))
                .totalItems(String.valueOf(page.getTotalElements()))
                .totalItemsPerPage(String.valueOf(page.getNumberOfElements()))
                .currentPage(String.valueOf(pageNumber))
                .build();
    }

    public ProductResponse get(long id) {
        return productMapper.toFoodsRespone(productRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.PRODUCTS_FOOD_NOT_EXISTED)));
    }

    public ProductResponse update(ProductRequest request, long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.PRODUCTS_FOOD_NOT_EXISTED));

        productMapper.updateFoods(product, request);

        return productMapper.toFoodsRespone(productRepository.save(product));
    }

    public void delete(long id) {
        Product food = productRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.PRODUCTS_FOOD_NOT_EXISTED));
        food.setStatus(0);
        productRepository.save(food);
    }
}
