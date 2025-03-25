package com.project.restaurantly.Controller.order;

import com.project.restaurantly.Service.order.PaymentsService;
import com.project.restaurantly.dto.request.order.PaymentsRequest;
import com.project.restaurantly.dto.response.ApiResponse;
import com.project.restaurantly.dto.response.order.PaymentsResponse;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.prefix}payments")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class PaymentsController {
    PaymentsService paymentService;

    //    @PreAuthorize("@requiredPermission.checkPermission('PERM_ADD')")
    @PostMapping
    ApiResponse<PaymentsResponse> create(@RequestBody @Valid PaymentsRequest request) {
        return ApiResponse.<PaymentsResponse>builder()
                .result(paymentService.create(request))
                .build();
    }

//    @PreAuthorize("@requiredPermission.checkPermission('PERM_VIEW')")
    @GetMapping("/get")
    ApiResponse<List<PaymentsResponse>> getAll(int status) {
        return ApiResponse.<List<PaymentsResponse>>builder()
                .result(paymentService.getAll(status))
                .build();
    }

    @GetMapping("/by")
    ApiResponse<PaymentsResponse> getMenu(@RequestParam(name = "id", required = false) long id) {
        return ApiResponse.<PaymentsResponse>builder()
                .result(paymentService.get(id))
                .build();
    }

    //    @PreAuthorize("@requiredPermission.checkPermission('PERM_EDIT')")
    @PutMapping()
    ApiResponse<PaymentsResponse> updateMenu(@RequestBody @Valid PaymentsRequest request, @RequestParam long id) {
        return ApiResponse.<PaymentsResponse>builder()
                .result(paymentService.update(request, id))
                .build();
    }

    //    @PreAuthorize("@requiredPermission.checkPermission('PERM_DELETE')")
    @DeleteMapping()
    ApiResponse<String> delete(@RequestParam(name = "id", required = false) long id) {
        paymentService.delete(id);
        return ApiResponse.<String>builder()
                .result("Payment has been deleted")
                .build();
    }
}
