package com.project.restaurantly.Mapper.products;

import com.project.restaurantly.Entity.products.DiscountCodes;
import com.project.restaurantly.dto.request.products.DiscountCodesRequest;
import com.project.restaurantly.dto.response.products.DiscountCodesResponse;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.3 (Oracle Corporation)"
)
@Component
public class DiscountCodesMapperImpl implements DiscountCodesMapper {

    @Override
    public DiscountCodes toDiscount(DiscountCodesRequest request) {
        if ( request == null ) {
            return null;
        }

        DiscountCodes.DiscountCodesBuilder discountCodes = DiscountCodes.builder();

        discountCodes.title( request.getTitle() );
        discountCodes.code( request.getCode() );
        discountCodes.discount_value( request.getDiscount_value() );
        discountCodes.discount_type( request.getDiscount_type() );
        discountCodes.discount_category( request.getDiscount_category() );
        discountCodes.start_date( request.getStart_date() );
        discountCodes.end_date( request.getEnd_date() );
        discountCodes.is_active( request.getIs_active() );
        discountCodes.usage_limit( request.getUsage_limit() );
        discountCodes.used_count( request.getUsed_count() );
        discountCodes.min_price( request.getMin_price() );
        discountCodes.max_discount( request.getMax_discount() );
        discountCodes.description( request.getDescription() );

        return discountCodes.build();
    }

    @Override
    public DiscountCodesResponse toDiscountResponse(DiscountCodes discountCodes) {
        if ( discountCodes == null ) {
            return null;
        }

        DiscountCodesResponse.DiscountCodesResponseBuilder discountCodesResponse = DiscountCodesResponse.builder();

        discountCodesResponse.id( discountCodes.getId() );
        discountCodesResponse.title( discountCodes.getTitle() );
        discountCodesResponse.code( discountCodes.getCode() );
        discountCodesResponse.discount_value( discountCodes.getDiscount_value() );
        discountCodesResponse.discount_type( discountCodes.getDiscount_type() );
        discountCodesResponse.discount_category( discountCodes.getDiscount_category() );
        discountCodesResponse.start_date( discountCodes.getStart_date() );
        discountCodesResponse.end_date( discountCodes.getEnd_date() );
        discountCodesResponse.is_active( discountCodes.getIs_active() );
        discountCodesResponse.usage_limit( discountCodes.getUsage_limit() );
        discountCodesResponse.used_count( discountCodes.getUsed_count() );
        discountCodesResponse.min_price( discountCodes.getMin_price() );
        discountCodesResponse.max_discount( discountCodes.getMax_discount() );
        discountCodesResponse.description( discountCodes.getDescription() );

        return discountCodesResponse.build();
    }

    @Override
    public void updateDiscountCodes(DiscountCodes discountCodes, DiscountCodesRequest request) {
        if ( request == null ) {
            return;
        }

        discountCodes.setTitle( request.getTitle() );
        discountCodes.setCode( request.getCode() );
        discountCodes.setDiscount_value( request.getDiscount_value() );
        discountCodes.setDiscount_type( request.getDiscount_type() );
        discountCodes.setDiscount_category( request.getDiscount_category() );
        discountCodes.setStart_date( request.getStart_date() );
        discountCodes.setEnd_date( request.getEnd_date() );
        discountCodes.setIs_active( request.getIs_active() );
        discountCodes.setUsage_limit( request.getUsage_limit() );
        discountCodes.setUsed_count( request.getUsed_count() );
        discountCodes.setMin_price( request.getMin_price() );
        discountCodes.setMax_discount( request.getMax_discount() );
        discountCodes.setDescription( request.getDescription() );
    }
}
