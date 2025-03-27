package com.project.restaurantly.Controller.products;

import com.project.restaurantly.Service.products.ProductService;
import com.project.restaurantly.dto.request.products.ProductRequest;
import com.project.restaurantly.dto.response.ApiResponse;
import com.project.restaurantly.dto.response.products.ProductResponse;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.prefix}products/food")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class ProductController {
    ProductService productService;

    //    @PreAuthorize("@requiredPermission.checkPermission('PERM_ADD')")
    @PostMapping
    ApiResponse<ProductResponse> create(@RequestBody @Valid ProductRequest request) {
        return ApiResponse.<ProductResponse>builder()
                .result(productService.create(request))
                .build();
    }

    //    @PreAuthorize("@requiredPermission.checkPermission('PERM_VIEW')")
    @GetMapping
    ApiResponse<List<ProductResponse>> searchAll(@RequestParam int pageNumber,
                                                 @RequestParam int size,
                                                 @RequestParam int status,
                                                 @RequestParam(name = "sort", required = false) String sort,
                                                 @RequestParam(name = "desc", required = false) String desc) {
        return ApiResponse.<List<ProductResponse>>builder()
                .result(productService.searchAll(pageNumber, size, status, sort, desc))
                .page(productService.getPagination(pageNumber, size, status, sort, desc))
                .build();
    }

    //    @PreAuthorize("@requiredPermission.checkPermission('PERM_VIEW')")
    @GetMapping("/get")
    ApiResponse<List<ProductResponse>> getAll() {
        return ApiResponse.<List<ProductResponse>>builder()
                .result(productService.getAll())
                .build();
    }

    @GetMapping("/by")
    ApiResponse<ProductResponse> getMenu(@RequestParam(name = "id", required = false) long id) {
        return ApiResponse.<ProductResponse>builder()
                .result(productService.get(id))
                .build();
    }

    //    @PreAuthorize("@requiredPermission.checkPermission('PERM_EDIT')")
    @PutMapping()
    ApiResponse<ProductResponse> updateMenu(@RequestBody @Valid ProductRequest request, @RequestParam long id) {
        return ApiResponse.<ProductResponse>builder()
                .result(productService.update(request, id))
                .build();
    }

    //    @PreAuthorize("@requiredPermission.checkPermission('PERM_DELETE')")
    @DeleteMapping()
    ApiResponse<String> delete(@RequestParam(name = "id", required = false) long id) {
        productService.delete(id);
        return ApiResponse.<String>builder()
                .result("Foods has been deleted")
                .build();
    }
}
