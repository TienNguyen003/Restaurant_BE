package com.project.restaurantly.Controller.settings;

import com.project.restaurantly.Entity.settings.Home_settings;
import com.project.restaurantly.Service.settings.HomeSettingService;
import com.project.restaurantly.dto.response.ApiResponse;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.prefix}home_settings")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class HomeSettingController {
    HomeSettingService homeSettingService;

//    @PreAuthorize("@requiredPermission.checkPermission('PERM_ADD')")
    @PostMapping
    ApiResponse<Home_settings> create(@RequestBody @Valid Home_settings request){
        return ApiResponse.<Home_settings>builder()
                .result(homeSettingService.create(request))
                .build();
    }

//    @PreAuthorize("@requiredPermission.checkPermission('PERM_VIEW')")
    @GetMapping
    ApiResponse<List<Home_settings>> getAll(@RequestParam String beLong){
        return ApiResponse.<List<Home_settings>>builder()
                .result(homeSettingService.getAll(beLong))
                .build();
    }

//    @PreAuthorize("@requiredPermission.checkPermission('PERM_DELETE')")
    @DeleteMapping
    ApiResponse<Void> delete(@RequestParam long id){
        homeSettingService.delete(id);
        return ApiResponse.<Void>builder().build();
    }
}
