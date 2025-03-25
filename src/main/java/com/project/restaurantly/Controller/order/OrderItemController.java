package com.project.restaurantly.Controller.order;

import com.project.restaurantly.Service.order.OrderItemsService;
import com.project.restaurantly.dto.request.order.OrderItemsRequest;
import com.project.restaurantly.dto.response.ApiResponse;
import com.project.restaurantly.dto.response.order.OrderItemsResponse;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.prefix}order-item")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class OrderItemController {
    OrderItemsService orderService;

    //    @PreAuthorize("@requiredPermission.checkPermission('PERM_ADD')")
    @PostMapping
    ApiResponse<OrderItemsResponse> create(@RequestBody @Valid OrderItemsRequest request) {
        return ApiResponse.<OrderItemsResponse>builder()
                .result(orderService.create(request))
                .build();
    }

//    @PreAuthorize("@requiredPermission.checkPermission('PERM_VIEW')")
    @GetMapping("/get")
    ApiResponse<List<OrderItemsResponse>> getAll(int status) {
        return ApiResponse.<List<OrderItemsResponse>>builder()
                .result(orderService.getAll(status))
                .build();
    }

    @GetMapping("/by")
    ApiResponse<OrderItemsResponse> getMenu(@RequestParam(name = "id", required = false) long id) {
        return ApiResponse.<OrderItemsResponse>builder()
                .result(orderService.get(id))
                .build();
    }

    //    @PreAuthorize("@requiredPermission.checkPermission('PERM_EDIT')")
    @PutMapping()
    ApiResponse<OrderItemsResponse> updateMenu(@RequestBody @Valid OrderItemsRequest request, @RequestParam long id) {
        return ApiResponse.<OrderItemsResponse>builder()
                .result(orderService.update(request, id))
                .build();
    }

    //    @PreAuthorize("@requiredPermission.checkPermission('PERM_DELETE')")
    @DeleteMapping()
    ApiResponse<String> delete(@RequestParam(name = "id", required = false) long id) {
        orderService.delete(id);
        return ApiResponse.<String>builder()
                .result("Order item has been deleted")
                .build();
    }
}
