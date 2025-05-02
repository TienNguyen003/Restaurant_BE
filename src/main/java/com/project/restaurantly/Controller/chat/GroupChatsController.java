package com.project.restaurantly.Controller.chat;

import com.project.restaurantly.Service.chat.GroupChatsService;
import com.project.restaurantly.dto.request.chat.GroupChatsRequest;
import com.project.restaurantly.dto.response.ApiResponse;
import com.project.restaurantly.dto.response.chat.GroupChatsResponse;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.prefix}chat-group")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class GroupChatsController {
    GroupChatsService chatService;

    //    @PreAuthorize("@requiredPermission.checkPermission('PERM_ADD')")
    @PostMapping
    ApiResponse<GroupChatsResponse> create(@RequestBody @Valid GroupChatsRequest request) {
        return ApiResponse.<GroupChatsResponse>builder()
                .result(chatService.create(request))
                .build();
    }

//    @PreAuthorize("@requiredPermission.checkPermission('PERM_VIEW')")
    @GetMapping("/get")
    ApiResponse<List<GroupChatsResponse>> getAll(@RequestParam int status) {
        return ApiResponse.<List<GroupChatsResponse>>builder()
                .result(chatService.getAll(status))
                .build();
    }

    @GetMapping("/by")
    ApiResponse<GroupChatsResponse> getMenu(@RequestParam(name = "id", required = false) long id) {
        return ApiResponse.<GroupChatsResponse>builder()
                .result(chatService.get(id))
                .build();
    }

    //    @PreAuthorize("@requiredPermission.checkPermission('PERM_EDIT')")
    @PutMapping()
    ApiResponse<GroupChatsResponse> updateMenu(@RequestBody @Valid GroupChatsRequest request, @RequestParam long id) {
        return ApiResponse.<GroupChatsResponse>builder()
                .result(chatService.update(request, id))
                .build();
    }

    //    @PreAuthorize("@requiredPermission.checkPermission('PERM_DELETE')")
    @DeleteMapping
    ApiResponse<String> delete(@RequestParam(name = "id", required = false) long id) {
        chatService.delete(id);
        return ApiResponse.<String>builder()
                .result("Group chat has been deleted")
                .build();
    }
}
