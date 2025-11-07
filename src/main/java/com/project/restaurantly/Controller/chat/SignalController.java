package com.project.restaurantly.Controller.chat;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;

public class SignalController {
    private final SimpMessagingTemplate messagingTemplate;

    public SignalController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    // Khi client gửi tới /app/signal/{userId}
    @MessageMapping("/signal/{userId}")
    public void signaling(@DestinationVariable String userId, @Payload String signalData) {
        // Gửi lại cho user đó qua topic riêng /topic/signal/{userId}
        messagingTemplate.convertAndSend("/topic/signal/" + userId, signalData);
    }
}
