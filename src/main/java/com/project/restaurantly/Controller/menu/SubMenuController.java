package com.project.restaurantly.Controller.menu;

import com.project.restaurantly.Service.menu.SubMenuService;
import com.project.restaurantly.dto.request.menu.SubMenuRequest;
import com.project.restaurantly.dto.response.ApiResponse;
import com.project.restaurantly.dto.response.menu.SubMenuResponse;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.prefix}submenu")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class SubMenuController {
    SubMenuService subMenuService;

//    @PreAuthorize("@requiredPermission.checkPermission('PERM_ADD')")
    @PostMapping
    ApiResponse<SubMenuResponse> create(@RequestBody @Valid SubMenuRequest request){
        return ApiResponse.<SubMenuResponse>builder()
                .result(subMenuService.create(request))
                .build();
    }

//    @PreAuthorize("@requiredPermission.checkPermission('PERM_VIEW')")
    @GetMapping
    ApiResponse<List<SubMenuResponse>> searchAll(@RequestParam int pageNumber,
                                                 @RequestParam int size,
                                              @RequestParam(name = "name", required = false) String name){
        return ApiResponse.<List<SubMenuResponse>>builder()
                .result(subMenuService.searchAll(name, pageNumber, size))
                .page(subMenuService.getPagination(pageNumber, size, name))
                .build();
    }

//    @PreAuthorize("@requiredPermission.checkPermission('PERM_VIEW')")
    @GetMapping("/get")
    ApiResponse<List<SubMenuResponse>> getAll(){
        return ApiResponse.<List<SubMenuResponse>>builder()
                .result(subMenuService.getAll())
                .build();
    }

    @GetMapping("/sub-menu")
    ApiResponse<SubMenuResponse> getSubMenu(@RequestParam(name = "id", required = false) long id){
        return ApiResponse.<SubMenuResponse>builder()
                .result(subMenuService.get(id))
                .build();
    }

//    @PreAuthorize("@requiredPermission.checkPermission('PERM_EDIT')")
    @PutMapping()
    ApiResponse<SubMenuResponse> updateRole(@RequestBody @Valid SubMenuRequest request, @RequestParam long id){
        return ApiResponse.<SubMenuResponse>builder()
                .result(subMenuService.update(request, id))
                .build();
    }

//    @PreAuthorize("@requiredPermission.checkPermission('PERM_DELETE')")
    @DeleteMapping()
    ApiResponse<String> delete(@RequestParam(name = "id", required = false) long id){
        subMenuService.delete(id);
        return ApiResponse.<String>builder()
                .result("Role has been deleted")
                .build();
    }
}
