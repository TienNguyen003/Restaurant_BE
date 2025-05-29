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
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.prefix}chat-meta")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class UserChatMetaController {
    UserChatMetaService metaService;
    SimpMessagingTemplate messagingTemplate;

    //    @PreAuthorize("@requiredPermission.checkPermission('PERM_ADD')")
    @PostMapping
    ApiResponse<String> create(@RequestBody @Valid UserChatMetaRequest request) {
        metaService.create(request);
        messagingTemplate.convertAndSend("/topic/chat-meta", "tien");
        return ApiResponse.<String>builder()
                .result("Create success")
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
    ApiResponse<List<UserChatMetaResponse>> getMenu(@RequestParam long chatId, @RequestParam String userId, @RequestParam int chatType) {
        return ApiResponse.<List<UserChatMetaResponse>>builder()
                .result(metaService.get(chatId, userId, chatType))
                .build();
    }

    //    @PreAuthorize("@requiredPermission.checkPermission('PERM_EDIT')")
    @PutMapping()
    ApiResponse<String> updateChatMeta(@RequestBody @Valid UserChatMetaRequest request, @RequestParam long id) {
        metaService.update(request, id);
        messagingTemplate.convertAndSend("/topic/chat-meta", "tien");
        return ApiResponse.<String>builder()
                .result("Update success")
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
