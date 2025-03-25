package com.project.restaurantly.Mapper.products;

import com.project.restaurantly.Entity.products.Product;
import com.project.restaurantly.dto.request.products.ProductRequest;
import com.project.restaurantly.dto.response.products.ProductResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product toFoods(ProductRequest request);

    ProductResponse toFoodsRespone(Product menu);

    void updateFoods(@MappingTarget Product menu, ProductRequest request);
}
