package com.project.restaurantly.Controller.chat;

import com.project.restaurantly.Service.chat.UserChatMetaService;
import com.project.restaurantly.dto.request.chat.UserChatMetaRequest;
import com.project.restaurantly.dto.response.ApiResponse;
import com.project.restaurantly.dto.response.chat.UserChatMetaResponse;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.prefix}chat-meta")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class UserChatMetaController {
    UserChatMetaService metaService;

    //    @PreAuthorize("@requiredPermission.checkPermission('PERM_ADD')")
    @PostMapping
    ApiResponse<UserChatMetaResponse> create(@RequestBody @Valid UserChatMetaRequest request) {
        return ApiResponse.<UserChatMetaResponse>builder()
                .result(metaService.create(request))
                .build();
    }

//    @PreAuthorize("@requiredPermission.checkPermission('PERM_VIEW')")
    @GetMapping("/get")
    ApiResponse<List<UserChatMetaResponse>> getAll() {
        return ApiResponse.<List<UserChatMetaResponse>>builder()
                .result(metaService.getAll())
                .build();
    }

    @GetMapping("/by")
    ApiResponse<UserChatMetaResponse> getMenu(@RequestParam(name = "id", required = false) long id) {
        return ApiResponse.<UserChatMetaResponse>builder()
                .result(metaService.get(id))
                .build();
    }

    //    @PreAuthorize("@requiredPermission.checkPermission('PERM_EDIT')")
    @PutMapping()
    ApiResponse<UserChatMetaResponse> updateMenu(@RequestBody @Valid UserChatMetaRequest request, @RequestParam long id) {
        return ApiResponse.<UserChatMetaResponse>builder()
                .result(metaService.update(request, id))
                .build();
    }

    //    @PreAuthorize("@requiredPermission.checkPermission('PERM_DELETE')")
    @DeleteMapping
    ApiResponse<String> delete(@RequestParam(name = "id", required = false) long id) {
        metaService.delete(id);
        return ApiResponse.<String>builder()
                .result("User chat meta has been deleted")
                .build();
    }
}
