package com.project.restaurantly.Mapper.products;

import com.project.restaurantly.Entity.products.ReviewProduct;
import com.project.restaurantly.dto.request.products.ReviewRequest;
import com.project.restaurantly.dto.response.products.ReviewResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ReviewMapper {
    ReviewProduct toReview(ReviewRequest request);

    ReviewResponse toReviewResponse(ReviewProduct review);

    void updateReview(@MappingTarget ReviewProduct review, ReviewRequest request);
}
