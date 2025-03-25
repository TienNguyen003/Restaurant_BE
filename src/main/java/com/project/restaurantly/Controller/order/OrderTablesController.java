package com.project.restaurantly.Controller.order;

import com.project.restaurantly.Service.order.OrderTablesService;
import com.project.restaurantly.dto.request.order.OrderTablesRequest;
import com.project.restaurantly.dto.response.ApiResponse;
import com.project.restaurantly.dto.response.order.OrderTablesResponse;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.prefix}order-table")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class OrderTablesController {
    OrderTablesService orderService;

    //    @PreAuthorize("@requiredPermission.checkPermission('PERM_ADD')")
    @PostMapping
    ApiResponse<OrderTablesResponse> create(@RequestBody @Valid OrderTablesRequest request) {
        return ApiResponse.<OrderTablesResponse>builder()
                .result(orderService.create(request))
                .build();
    }

//    @PreAuthorize("@requiredPermission.checkPermission('PERM_VIEW')")
    @GetMapping("/get")
    ApiResponse<List<OrderTablesResponse>> getAll(int status) {
        return ApiResponse.<List<OrderTablesResponse>>builder()
                .result(orderService.getAll(status))
                .build();
    }

    @GetMapping("/by")
    ApiResponse<OrderTablesResponse> getMenu(@RequestParam(name = "id", required = false) long id) {
        return ApiResponse.<OrderTablesResponse>builder()
                .result(orderService.get(id))
                .build();
    }

    //    @PreAuthorize("@requiredPermission.checkPermission('PERM_EDIT')")
    @PutMapping()
    ApiResponse<OrderTablesResponse> updateMenu(@RequestBody @Valid OrderTablesRequest request, @RequestParam long id) {
        return ApiResponse.<OrderTablesResponse>builder()
                .result(orderService.update(request, id))
                .build();
    }

    //    @PreAuthorize("@requiredPermission.checkPermission('PERM_DELETE')")
    @DeleteMapping()
    ApiResponse<String> delete(@RequestParam(name = "id", required = false) long id) {
        orderService.delete(id);
        return ApiResponse.<String>builder()
                .result("Order table has been deleted")
                .build();
    }
}
