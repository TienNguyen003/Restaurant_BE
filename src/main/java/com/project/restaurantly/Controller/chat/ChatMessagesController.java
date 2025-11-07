package com.project.restaurantly.Controller.chat;

import com.project.restaurantly.Service.chat.ChatMessagesService;
import com.project.restaurantly.dto.request.chat.ChatMessagesRequest;
import com.project.restaurantly.dto.response.ApiResponse;
import com.project.restaurantly.dto.response.chat.ChatMessagesResponse;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.prefix}chat-message")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class ChatMessagesController {
    ChatMessagesService chatService;
    SimpMessagingTemplate messagingTemplate;

    // @PreAuthorize("@requiredPermission.checkPermission('PERM_ADD')")
    @PostMapping
    ApiResponse<String> create(@RequestBody @Valid ChatMessagesRequest request) {
        chatService.create(request);
        messagingTemplate.convertAndSend("/topic/send-chat", "tien");
        return ApiResponse.<String>builder()
                .result("Success")
                .build();
    }

    // @PreAuthorize("@requiredPermission.checkPermission('PERM_VIEW')")
    @GetMapping("/get")
    ApiResponse<List<ChatMessagesResponse>> getAll(@RequestParam int status) {
        return ApiResponse.<List<ChatMessagesResponse>>builder()
                .result(chatService.getAll(status))
                .build();
    }

    @GetMapping("/by")
    ApiResponse<List<ChatMessagesResponse>> getMenu(@RequestParam(required = false) String status,
            @RequestParam long chatId) {
        return ApiResponse.<List<ChatMessagesResponse>>builder()
                .result(chatService.get(status, chatId))
                .build();
    }

    @GetMapping("/is_pined")
    ApiResponse<String> updatePined(@RequestParam int status, @RequestParam long chatId, @RequestParam long id,
            @RequestParam int type) {
        String result = chatService.updatePinned(chatId, status, id, type);
        messagingTemplate.convertAndSend("/topic/send-chat", "tien");
        return ApiResponse.<String>builder()
                .result(result)
                .build();
    }

    // @PreAuthorize("@requiredPermission.checkPermission('PERM_EDIT')")
    @PutMapping()
    ApiResponse<String> updateMenu(@RequestParam String messageText, @RequestParam long id) {
        chatService.update(messageText, id);
        messagingTemplate.convertAndSend("/topic/send-chat", "tien");
        return ApiResponse.<String>builder()
                .result("Success")
                .build();
    }

    // @PreAuthorize("@requiredPermission.checkPermission('PERM_DELETE')")
    @DeleteMapping
    ApiResponse<String> delete(@RequestParam(name = "id", required = false) long id) {
        chatService.delete(id);
        messagingTemplate.convertAndSend("/topic/send-chat", "tien");
        return ApiResponse.<String>builder()
                .result("Message has been deleted")
                .build();
    }
}
