package com.project.restaurantly.Service.products;

import com.project.restaurantly.Entity.PageCustom;
import com.project.restaurantly.Entity.products.Product;
import com.project.restaurantly.Entity.products.ReviewProduct;
import com.project.restaurantly.Entity.user.User;
import com.project.restaurantly.Exception.AppException;
import com.project.restaurantly.Exception.ErrorCode;
import com.project.restaurantly.Mapper.products.ReviewMapper;
import com.project.restaurantly.dto.request.products.ReviewRequest;
import com.project.restaurantly.dto.response.products.ReviewResponse;
import com.project.restaurantly.repository.products.ProductRepository;
import com.project.restaurantly.repository.products.ReviewRepository;
import com.project.restaurantly.repository.user.UserRepository;
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
public class ReviewService {
    ReviewRepository reviewRepository;
    ProductRepository productRepository;
    UserRepository userRepository;
    ReviewMapper reviewMapper;

    public ReviewResponse create(ReviewRequest request) {
        ReviewProduct review = reviewMapper.toReview(request);

        Product product = productRepository.findById(request.getProduct_id())
                .orElseThrow(() -> new AppException(ErrorCode.PRODUCTS_FOOD_NOT_EXISTED));

        User user = userRepository.findById(request.getUser_id())
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));

        review.setProduct(product);
        review.setUser(user);
        reviewRepository.save(review);

        return reviewMapper.toReviewResponse(review);
    }

    public List<ReviewResponse> getAll() {
        return reviewRepository.findAll().stream().map(reviewMapper::toReviewResponse).toList();
    }

    public List<ReviewResponse> searchAll(int pageNumber, int size, int status, long product_id) {
        Pageable pageable = PageRequest.of(pageNumber - 1, size);
        return reviewRepository.findByProductId(pageable, status, product_id)
                .stream()
                .map(reviewMapper::toReviewResponse)
                .toList();
    }

    public PageCustom getPagination(int pageNumber, int size, int status, long product_id) {
        Pageable pageable = PageRequest.of(pageNumber - 1, size);
        Page<ReviewProduct> page = reviewRepository.findByProductId(pageable, status, product_id);
        return PageCustom.builder()
                .totalPages(String.valueOf(page.getTotalPages()))
                .totalItems(String.valueOf(page.getTotalElements()))
                .totalItemsPerPage(String.valueOf(page.getNumberOfElements()))
                .currentPage(String.valueOf(pageNumber))
                .build();
    }

    public Object[] get(long productId, int status) {
        return reviewRepository.findRatingSumAndCountByProductId(productId, status);
    }

    public ReviewResponse update(ReviewRequest request, long id) {
        ReviewProduct review = reviewRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.PRODUCTS_FOOD_NOT_EXISTED));

        reviewMapper.updateReview(review, request);

        return reviewMapper.toReviewResponse(reviewRepository.save(review));
    }

    public void delete(long id) {
        ReviewProduct review = reviewRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.PRODUCTS_FOOD_NOT_EXISTED));
        review.setStatus(0);
        reviewRepository.save(review);
    }
}
