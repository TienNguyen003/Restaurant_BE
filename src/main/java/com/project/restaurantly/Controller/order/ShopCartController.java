package com.project.restaurantly.Controller.order;

import com.project.restaurantly.Service.order.ShopCartService;
import com.project.restaurantly.dto.request.order.ShopCartRequest;
import com.project.restaurantly.dto.response.ApiResponse;
import com.project.restaurantly.dto.response.order.ShopCartResponse;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.prefix}cart")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class ShopCartController {
    ShopCartService cartService;

    //    @PreAuthorize("@requiredPermission.checkPermission('PERM_ADD')")
    @PostMapping
    ApiResponse<ShopCartResponse> create(@RequestBody @Valid ShopCartRequest request) {
        return ApiResponse.<ShopCartResponse>builder()
                .result(cartService.create(request))
                .build();
    }

//    @PreAuthorize("@requiredPermission.checkPermission('PERM_VIEW')")
    @GetMapping("/get")
    ApiResponse<List<ShopCartResponse>> getAll(int status) {
        return ApiResponse.<List<ShopCartResponse>>builder()
                .result(cartService.getAll(status))
                .build();
    }

    @GetMapping("/by")
    ApiResponse<List<ShopCartResponse>> getMenu(@RequestParam int status,
                                                @RequestParam int pageNumber,
                                                @RequestParam int size,
                                                @RequestParam(name = "id", required = false) long id,
                                                @RequestParam(name = "sort", required = false) String sort,
                                                @RequestParam(name = "desc", required = false) String desc) {
        return ApiResponse.<List<ShopCartResponse>>builder()
                .result(cartService.searchAll(id, pageNumber, size, status, sort, desc))
                .page(cartService.getPagination(pageNumber, size, id, status))
                .build();
    }

    //    @PreAuthorize("@requiredPermission.checkPermission('PERM_EDIT')")
    @PutMapping
    ApiResponse<ShopCartResponse> update(@RequestBody @Valid ShopCartRequest request, @RequestParam long id) {
        return ApiResponse.<ShopCartResponse>builder()
                .result(cartService.update(request, id))
                .build();
    }

    @PutMapping("/quantity")
    public ApiResponse<ShopCartResponse> updateQuantity(@RequestParam int quantity, @RequestParam long id) {
        return ApiResponse.<ShopCartResponse>builder()
                .result(cartService.updateQuantity(quantity, id))
                .build();
    }

    //    @PreAuthorize("@requiredPermission.checkPermission('PERM_DELETE')")
    @DeleteMapping
    ApiResponse<String> delete(@RequestParam List<Long> ids) {
        cartService.delete(ids);
        return ApiResponse.<String>builder()
                .result("Shop cart has been deleted")
                .build();
    }
}
