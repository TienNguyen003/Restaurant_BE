package com.project.restaurantly.Controller.menu;

import com.project.restaurantly.Service.menu.MenuService;
import com.project.restaurantly.dto.request.menu.MenuRequest;
import com.project.restaurantly.dto.response.ApiResponse;
import com.project.restaurantly.dto.response.menu.MenuResponse;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.prefix}menu")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class MenuController {
    MenuService menuService;

    //    @PreAuthorize("@requiredPermission.checkPermission('PERM_ADD')")
    @PostMapping
    ApiResponse<MenuResponse> create(@RequestBody @Valid MenuRequest request) {
        return ApiResponse.<MenuResponse>builder()
                .result(menuService.create(request))
                .build();
    }

    //    @PreAuthorize("@requiredPermission.checkPermission('PERM_VIEW')")
    @GetMapping
    ApiResponse<List<MenuResponse>> searchAll(@RequestParam int pageNumber,
                                              @RequestParam int size,
                                              @RequestParam int status,
                                              @RequestParam(name = "name", required = false) String name) {
        return ApiResponse.<List<MenuResponse>>builder()
                .result(menuService.searchAll(name, pageNumber, size, status))
                .page(menuService.getPagination(pageNumber, size, name, status))
                .build();
    }

    //    @PreAuthorize("@requiredPermission.checkPermission('PERM_VIEW')")
    @GetMapping("/get")
    ApiResponse<List<MenuResponse>> getAll(@RequestParam int status) {
        return ApiResponse.<List<MenuResponse>>builder()
                .result(menuService.getAll(status))
                .build();
    }

    @GetMapping("/menu")
    ApiResponse<MenuResponse> getMenu(@RequestParam(name = "id", required = false) long id) {
        return ApiResponse.<MenuResponse>builder()
                .result(menuService.get(id))
                .build();
    }

    //    @PreAuthorize("@requiredPermission.checkPermission('PERM_EDIT')")
    @PutMapping()
    ApiResponse<MenuResponse> updateMenu(@RequestBody @Valid MenuRequest request, @RequestParam long id) {
        return ApiResponse.<MenuResponse>builder()
                .result(menuService.update(request, id))
                .build();
    }

    //    @PreAuthorize("@requiredPermission.checkPermission('PERM_DELETE')")
    @DeleteMapping()
    ApiResponse<String> delete(@RequestParam(name = "id", required = false) long id) {
        menuService.delete(id);
        return ApiResponse.<String>builder()
                .result("Menu has been deleted")
                .build();
    }
}
