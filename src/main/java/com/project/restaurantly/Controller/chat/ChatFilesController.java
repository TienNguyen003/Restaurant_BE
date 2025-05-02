package com.project.restaurantly.Controller.chat;

import com.project.restaurantly.Service.chat.ChatFilesService;
import com.project.restaurantly.dto.request.chat.ChatFilesRequest;
import com.project.restaurantly.dto.response.ApiResponse;
import com.project.restaurantly.dto.response.chat.ChatFilesResponse;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.prefix}chat-file")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class ChatFilesController {
    ChatFilesService chatService;

    //    @PreAuthorize("@requiredPermission.checkPermission('PERM_ADD')")
    @PostMapping
    ApiResponse<ChatFilesResponse> create(@RequestBody @Valid ChatFilesRequest request) {
        return ApiResponse.<ChatFilesResponse>builder()
                .result(chatService.create(request))
                .build();
    }

//    @PreAuthorize("@requiredPermission.checkPermission('PERM_VIEW')")
    @GetMapping("/get")
    ApiResponse<List<ChatFilesResponse>> getAll(@RequestParam int status) {
        return ApiResponse.<List<ChatFilesResponse>>builder()
                .result(chatService.getAll(status))
                .build();
    }

    @GetMapping("/by")
    ApiResponse<ChatFilesResponse> getMenu(@RequestParam(name = "id", required = false) long id) {
        return ApiResponse.<ChatFilesResponse>builder()
                .result(chatService.get(id))
                .build();
    }

    //    @PreAuthorize("@requiredPermission.checkPermission('PERM_EDIT')")
    @PutMapping()
    ApiResponse<ChatFilesResponse> updateMenu(@RequestBody @Valid ChatFilesRequest request, @RequestParam long id) {
        return ApiResponse.<ChatFilesResponse>builder()
                .result(chatService.update(request, id))
                .build();
    }

    //    @PreAuthorize("@requiredPermission.checkPermission('PERM_DELETE')")
    @DeleteMapping
    ApiResponse<String> delete(@RequestParam(name = "id", required = false) long id) {
        chatService.delete(id);
        return ApiResponse.<String>builder()
                .result("File has been deleted")
                .build();
    }
}
