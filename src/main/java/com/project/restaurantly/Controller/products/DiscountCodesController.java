package com.project.restaurantly.Controller.products;

import com.project.restaurantly.Service.products.DiscountCodesService;
import com.project.restaurantly.dto.request.products.DiscountCodesRequest;
import com.project.restaurantly.dto.response.ApiResponse;
import com.project.restaurantly.dto.response.products.DiscountCodesResponse;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.prefix}discount")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class DiscountCodesController {
    DiscountCodesService discountService;

    //    @PreAuthorize("@requiredPermission.checkPermission('PERM_ADD')")
    @PostMapping
    ApiResponse<DiscountCodesResponse> create(@RequestBody @Valid DiscountCodesRequest request) {
        return ApiResponse.<DiscountCodesResponse>builder()
                .result(discountService.create(request))
                .build();
    }

    //    @PreAuthorize("@requiredPermission.checkPermission('PERM_VIEW')")
    @GetMapping("/get")
    ApiResponse<List<DiscountCodesResponse>> getAll() {
        return ApiResponse.<List<DiscountCodesResponse>>builder()
                .result(discountService.getAll())
                .build();
    }

    @GetMapping("/by")
    ApiResponse<DiscountCodesResponse> getMenu(@RequestParam(name = "id", required = false) long id) {
        return ApiResponse.<DiscountCodesResponse>builder()
                .result(discountService.get(id))
                .build();
    }

    //    @PreAuthorize("@requiredPermission.checkPermission('PERM_EDIT')")
    @PutMapping()
    ApiResponse<DiscountCodesResponse> updateMenu(@RequestBody @Valid DiscountCodesRequest request, @RequestParam long id) {
        return ApiResponse.<DiscountCodesResponse>builder()
                .result(discountService.update(request, id))
                .build();
    }

    //    @PreAuthorize("@requiredPermission.checkPermission('PERM_DELETE')")
    @DeleteMapping()
    ApiResponse<String> delete(@RequestParam(name = "id", required = false) long id) {
        discountService.delete(id);
        return ApiResponse.<String>builder()
                .result("Discount has been deleted")
                .build();
    }
}
