package com.project.restaurantly.Controller.chat;

import com.project.restaurantly.Service.chat.MessagesReadService;
import com.project.restaurantly.dto.response.ApiResponse;
import com.project.restaurantly.dto.response.chat.MessagesReadResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("${api.prefix}message-read")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class MessagesReadController {
    MessagesReadService readService;
    SimpMessagingTemplate messagingTemplate;

    @GetMapping("/get")
    ApiResponse<String> updateRead(@RequestParam long chatId, @RequestParam int chatType, @RequestParam String userId) {
        readService.updateRead(chatId, chatType, userId);
        messagingTemplate.convertAndSend("/topic/message-read", "tien");
        return ApiResponse.<String>builder()
                .result("Update Success")
                .build();
    }

    @GetMapping
    ApiResponse<List<MessagesReadResponse>> getAll() {
        return ApiResponse.<List<MessagesReadResponse>>builder()
                .result(readService.getAll())
                .build();
    }
}
