package com.project.restaurantly.Mapper.products;

import com.project.restaurantly.Entity.products.DiscountCodes;
import com.project.restaurantly.dto.request.products.DiscountCodesRequest;
import com.project.restaurantly.dto.response.products.DiscountCodesResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface DiscountCodesMapper {
    DiscountCodes toDiscount(DiscountCodesRequest request);

    DiscountCodesResponse toDiscountResponse(DiscountCodes discountCodes);

    void updateDiscountCodes(@MappingTarget DiscountCodes discountCodes, DiscountCodesRequest request);
}
