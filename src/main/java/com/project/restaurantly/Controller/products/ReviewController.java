package com.project.restaurantly.Controller.products;

import com.project.restaurantly.Service.products.ReviewService;
import com.project.restaurantly.dto.request.products.ReviewRequest;
import com.project.restaurantly.dto.response.ApiResponse;
import com.project.restaurantly.dto.response.products.ReviewResponse;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.prefix}products/review")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class ReviewController {
    ReviewService reviewService;
    SimpMessagingTemplate messagingTemplate;

    //    @PreAuthorize("@requiredPermission.checkPermission('PERM_ADD')")
    @PostMapping
    ApiResponse<String> create(@RequestBody @Valid ReviewRequest request) {
        reviewService.create(request);
        messagingTemplate.convertAndSend("/topic/review", "tien");
        return ApiResponse.<String>builder()
                .result("Success")
                .build();
    }

    //    @PreAuthorize("@requiredPermission.checkPermission('PERM_VIEW')")
    @GetMapping
    ApiResponse<List<ReviewResponse>> searchAll(@RequestParam int pageNumber,
                                                 @RequestParam int size,
                                                 @RequestParam int status,
                                                 @RequestParam long product_id) {
        return ApiResponse.<List<ReviewResponse>>builder()
                .result(reviewService.searchAll(pageNumber, size, status, product_id))
                .page(reviewService.getPagination(pageNumber, size, status, product_id))
                .build();
    }

    //    @PreAuthorize("@requiredPermission.checkPermission('PERM_VIEW')")
    @GetMapping("/get")
    ApiResponse<List<ReviewResponse>> getAll() {
        return ApiResponse.<List<ReviewResponse>>builder()
                .result(reviewService.getAll())
                .build();
    }

    @GetMapping("/product_id")
    ApiResponse<Object[]> getMenu(@RequestParam long product_id, @RequestParam int status) {
        return ApiResponse.<Object[]>builder()
                .result(reviewService.get(product_id, status))
                .build();
    }

    //    @PreAuthorize("@requiredPermission.checkPermission('PERM_EDIT')")
    @PutMapping
    ApiResponse<ReviewResponse> updateMenu(@RequestBody @Valid ReviewRequest request, @RequestParam long id) {
        return ApiResponse.<ReviewResponse>builder()
                .result(reviewService.update(request, id))
                .build();
    }

    //    @PreAuthorize("@requiredPermission.checkPermission('PERM_DELETE')")
    @DeleteMapping()
    ApiResponse<String> delete(@RequestParam long id) {
        reviewService.delete(id);
        return ApiResponse.<String>builder()
                .result("Review has been deleted")
                .build();
    }
}
