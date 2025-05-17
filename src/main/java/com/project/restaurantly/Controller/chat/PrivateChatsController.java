package com.project.restaurantly.Controller.chat;

import com.project.restaurantly.Service.chat.PrivateChatsService;
import com.project.restaurantly.dto.request.chat.PrivateChatsRequest;
import com.project.restaurantly.dto.response.ApiResponse;
import com.project.restaurantly.dto.response.chat.PrivateChatsResponse;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.prefix}chat-private")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class PrivateChatsController {
    PrivateChatsService chatService;

    //    @PreAuthorize("@requiredPermission.checkPermission('PERM_ADD')")
    @PostMapping
    ApiResponse<PrivateChatsResponse> create(@RequestBody @Valid PrivateChatsRequest request) {
        return ApiResponse.<PrivateChatsResponse>builder()
                .result(chatService.create(request))
                .build();
    }

//    @PreAuthorize("@requiredPermission.checkPermission('PERM_VIEW')")
    @GetMapping("/get")
    ApiResponse<PrivateChatsResponse> getAll(@RequestParam long chatId) {
        return ApiResponse.<PrivateChatsResponse>builder()
                .result(chatService.getByChatId(chatId))
                .build();
    }

    @GetMapping("/by")
    ApiResponse<List<PrivateChatsResponse>> getMenu(@RequestParam int status, @RequestParam String idUser) {
        return ApiResponse.<List<PrivateChatsResponse>>builder()
                .result(chatService.get(idUser, status))
                .build();
    }

    //    @PreAuthorize("@requiredPermission.checkPermission('PERM_EDIT')")
    @PutMapping()
    ApiResponse<PrivateChatsResponse> updateMenu(@RequestBody @Valid PrivateChatsRequest request, @RequestParam long id) {
        return ApiResponse.<PrivateChatsResponse>builder()
                .result(chatService.update(request, id))
                .build();
    }

    //    @PreAuthorize("@requiredPermission.checkPermission('PERM_DELETE')")
    @DeleteMapping
    ApiResponse<String> delete(@RequestParam(name = "id", required = false) long id) {
        chatService.delete(id);
        return ApiResponse.<String>builder()
                .result("Private chat has been deleted")
                .build();
    }
}
