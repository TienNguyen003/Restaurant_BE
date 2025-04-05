package com.project.restaurantly.Controller.order;

import com.project.restaurantly.Service.order.OrdersService;
import com.project.restaurantly.dto.request.order.OrdersRequest;
import com.project.restaurantly.dto.response.ApiResponse;
import com.project.restaurantly.dto.response.order.OrdersResponse;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.prefix}order")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class OrdersController {
    OrdersService orderService;

    //    @PreAuthorize("@requiredPermission.checkPermission('PERM_ADD')")
    @PostMapping
    ApiResponse<OrdersResponse> create(@RequestBody @Valid OrdersRequest request) {
        return ApiResponse.<OrdersResponse>builder()
                .result(orderService.create(request))
                .build();
    }

    //    @PreAuthorize("@requiredPermission.checkPermission('PERM_VIEW')")
    @GetMapping("/get")
    ApiResponse<OrdersResponse> getAll(long id) {
        return ApiResponse.<OrdersResponse>builder()
                .result(orderService.getAll(id))
                .build();
    }

    @GetMapping("/by")
    ApiResponse<List<OrdersResponse>> getMenu(@RequestParam(name = "user_id", required = false) String user_id,
                                        @RequestParam(name = "sort", required = false) String sort,
                                        @RequestParam(name = "desc", required = false) String desc,
                                        @RequestParam int status,
                                        @RequestParam int pageNumber,
                                        @RequestParam int size) {
        return ApiResponse.<List<OrdersResponse>>builder()
                .result(orderService.searchAll(user_id, status, pageNumber, size, sort, desc))
                .page(orderService.getPagination(pageNumber, size, user_id, status))
                .build();
    }

    //    @PreAuthorize("@requiredPermission.checkPermission('PERM_EDIT')")
    @PutMapping()
    ApiResponse<OrdersResponse> updateMenu(@RequestBody @Valid OrdersRequest request, @RequestParam long id) {
        return ApiResponse.<OrdersResponse>builder()
                .result(orderService.update(request, id))
                .build();
    }

    //    @PreAuthorize("@requiredPermission.checkPermission('PERM_DELETE')")
    @DeleteMapping()
    ApiResponse<String> delete(@RequestParam(name = "id", required = false) long id) {
        orderService.delete(id);
        return ApiResponse.<String>builder()
                .result("Order has been deleted")
                .build();
    }
}
