package com.project.restaurantly.Mapper.products;

import com.project.restaurantly.Entity.products.ReviewProduct;
import com.project.restaurantly.dto.request.products.ReviewRequest;
import com.project.restaurantly.dto.response.products.ReviewResponse;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.3 (Oracle Corporation)"
)
@Component
public class ReviewMapperImpl implements ReviewMapper {

    @Override
    public ReviewProduct toReview(ReviewRequest request) {
        if ( request == null ) {
            return null;
        }

        ReviewProduct.ReviewProductBuilder reviewProduct = ReviewProduct.builder();

        reviewProduct.parent_review_id( request.getParent_review_id() );
        reviewProduct.rating( request.getRating() );
        reviewProduct.comment( request.getComment() );
        reviewProduct.created_at( request.getCreated_at() );
        reviewProduct.status( request.getStatus() );

        return reviewProduct.build();
    }

    @Override
    public ReviewResponse toReviewResponse(ReviewProduct review) {
        if ( review == null ) {
            return null;
        }

        ReviewResponse.ReviewResponseBuilder reviewResponse = ReviewResponse.builder();

        reviewResponse.id( review.getId() );
        reviewResponse.user( review.getUser() );
        reviewResponse.product( review.getProduct() );
        if ( review.getParent_review_id() != null ) {
            reviewResponse.parent_review_id( review.getParent_review_id() );
        }
        reviewResponse.rating( review.getRating() );
        reviewResponse.comment( review.getComment() );
        reviewResponse.created_at( review.getCreated_at() );
        reviewResponse.status( review.getStatus() );

        return reviewResponse.build();
    }

    @Override
    public void updateReview(ReviewProduct review, ReviewRequest request) {
        if ( request == null ) {
            return;
        }

        review.setParent_review_id( request.getParent_review_id() );
        review.setRating( request.getRating() );
        review.setComment( request.getComment() );
        review.setCreated_at( request.getCreated_at() );
        review.setStatus( request.getStatus() );
    }
}
