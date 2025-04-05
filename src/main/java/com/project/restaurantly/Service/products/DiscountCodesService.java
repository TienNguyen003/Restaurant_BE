package com.project.restaurantly.Service.products;

import com.project.restaurantly.Entity.PageCustom;
import com.project.restaurantly.Entity.products.DiscountCodes;
import com.project.restaurantly.Entity.products.Product;
import com.project.restaurantly.Exception.AppException;
import com.project.restaurantly.Exception.ErrorCode;
import com.project.restaurantly.Mapper.products.DiscountCodesMapper;
import com.project.restaurantly.Mapper.products.ProductMapper;
import com.project.restaurantly.dto.request.products.DiscountCodesRequest;
import com.project.restaurantly.dto.request.products.ProductRequest;
import com.project.restaurantly.dto.response.products.DiscountCodesResponse;
import com.project.restaurantly.dto.response.products.ProductResponse;
import com.project.restaurantly.repository.products.DiscountCodesRepository;
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
public class DiscountCodesService {
    DiscountCodesRepository discountRepository;
    DiscountCodesMapper discountMapper;

    public DiscountCodesResponse create(DiscountCodesRequest request) {
        DiscountCodes discount = discountMapper.toDiscount(request);

        discountRepository.save(discount);

        return discountMapper.toDiscountResponse(discount);
    }

    public List<DiscountCodesResponse> getAll() {
        return discountRepository.findAll().stream().map(discountMapper::toDiscountResponse).toList();
    }

    public DiscountCodesResponse get(long id) {
        return discountMapper.toDiscountResponse(discountRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.PRODUCTS_FOOD_NOT_EXISTED)));
    }

    public DiscountCodesResponse update(DiscountCodesRequest request, long id) {
        DiscountCodes discount = discountRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.PRODUCTS_FOOD_NOT_EXISTED));

        discountMapper.updateDiscountCodes(discount, request);

        return discountMapper.toDiscountResponse(discountRepository.save(discount));
    }

    public void delete(long id) {
        DiscountCodes discount = discountRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.PRODUCTS_FOOD_NOT_EXISTED));
        discount.setIs_active(0);
        discountRepository.save(discount);
    }
}
