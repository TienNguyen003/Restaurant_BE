package com.project.restaurantly.Controller.order;

import com.project.restaurantly.Service.order.FavoritesService;
import com.project.restaurantly.dto.request.order.FavoritesRequest;
import com.project.restaurantly.dto.response.ApiResponse;
import com.project.restaurantly.dto.response.order.FavoritesResponse;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.prefix}favorites")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class FavoritesController {
    FavoritesService favoriteService;

    //    @PreAuthorize("@requiredPermission.checkPermission('PERM_ADD')")
    @PostMapping
    ApiResponse<FavoritesResponse> create(@RequestBody @Valid FavoritesRequest request) {
        return ApiResponse.<FavoritesResponse>builder()
                .result(favoriteService.create(request))
                .build();
    }

//    @PreAuthorize("@requiredPermission.checkPermission('PERM_VIEW')")
    @GetMapping("/get")
    ApiResponse<List<FavoritesResponse>> getAll(int status) {
        return ApiResponse.<List<FavoritesResponse>>builder()
                .result(favoriteService.getAll(status))
                .build();
    }

    @GetMapping("/by")
    ApiResponse<FavoritesResponse> getMenu(@RequestParam(name = "id", required = false) long id) {
        return ApiResponse.<FavoritesResponse>builder()
                .result(favoriteService.get(id))
                .build();
    }

    //    @PreAuthorize("@requiredPermission.checkPermission('PERM_EDIT')")
    @PutMapping()
    ApiResponse<FavoritesResponse> updateMenu(@RequestBody @Valid FavoritesRequest request, @RequestParam long id) {
        return ApiResponse.<FavoritesResponse>builder()
                .result(favoriteService.update(request, id))
                .build();
    }

    //    @PreAuthorize("@requiredPermission.checkPermission('PERM_DELETE')")
    @DeleteMapping()
    ApiResponse<String> delete(@RequestParam(name = "id", required = false) long id) {
        favoriteService.delete(id);
        return ApiResponse.<String>builder()
                .result("Favorite has been deleted")
                .build();
    }
}
