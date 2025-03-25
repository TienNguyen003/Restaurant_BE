package com.project.restaurantly.Controller.role;

import com.project.restaurantly.Service.role.PermissionService;
import com.project.restaurantly.dto.response.ApiResponse;
import com.project.restaurantly.dto.request.role.PermissionRequest;
import com.project.restaurantly.dto.response.role.PermissionResponse;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.prefix}permission")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class PermissionController {
    PermissionService permissionService;

    @PreAuthorize("@requiredPermission.checkPermission('PERM_ADD')")
    @PostMapping
    ApiResponse<PermissionResponse> create(@RequestBody @Valid PermissionRequest permissionRequest){
        return ApiResponse.<PermissionResponse>builder()
                .result(permissionService.create(permissionRequest))
                .build();
    }

    @PreAuthorize("@requiredPermission.checkPermission('PERM_VIEW')")
    @GetMapping
    ApiResponse<List<PermissionResponse>> getAll(){
        return ApiResponse.<List<PermissionResponse>>builder()
                .result(permissionService.getAll())
                .build();
    }

    @PreAuthorize("@requiredPermission.checkPermission('PERM_DELETE')")
    @DeleteMapping("/{permissionName}")
    ApiResponse<Void> delete(@PathVariable String permissionName){
        permissionService.delete(permissionName);
        return ApiResponse.<Void>builder().build();
    }
}
