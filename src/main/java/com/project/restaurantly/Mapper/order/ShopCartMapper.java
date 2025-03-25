package com.project.restaurantly.Mapper.order;

import com.project.restaurantly.Entity.order.ShopCart;
import com.project.restaurantly.dto.request.order.ShopCartRequest;
import com.project.restaurantly.dto.response.order.ShopCartResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ShopCartMapper {
    ShopCart toCart(ShopCartRequest request);

    ShopCartResponse toCartResponse(ShopCart cart);

    void updateCart(@MappingTarget ShopCart cart, ShopCartRequest request);
}
