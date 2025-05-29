package com.project.restaurantly.Service.chat;

import com.project.restaurantly.Entity.chat.MessagesRead;
import com.project.restaurantly.Exception.AppException;
import com.project.restaurantly.Exception.ErrorCode;
import com.project.restaurantly.Mapper.chat.MessagesReadMapper;
import com.project.restaurantly.dto.request.chat.MessagesReadRequest;
import com.project.restaurantly.dto.response.chat.MessagesReadResponse;
import com.project.restaurantly.repository.chat.MessagesReadRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class MessagesReadService {
    MessagesReadRepository readRepository;
    MessagesReadMapper chatMapper;

    public MessagesReadResponse create(MessagesReadRequest request) {
        MessagesRead chat = chatMapper.toMessagesRead(request);

        readRepository.save(chat);

        return chatMapper.toMessagesReadResponse(chat);
    }


    public List<MessagesReadResponse> getAll() {
        var mess = readRepository.findAll();
        return mess.stream().map(chatMapper::toMessagesReadResponse).toList();
    }

    public List<MessagesRead> getBy(long chatId, int chatType, String userId) {
        return readRepository.findByChatIdAndChatTypeAndUserId(chatId, chatType, userId);
    }

    public MessagesReadResponse update(MessagesReadRequest request, long id) {
        MessagesRead chat = readRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.MENU_NOT_EXISTED));

        chatMapper.updateMessagesRead(chat, request);

        return chatMapper.toMessagesReadResponse(readRepository.save(chat));
    }

    public void delete(long id) {
        readRepository.deleteById(id);
    }

    public String updateRead(long messageId, int chatType, String userId){
        List<MessagesRead> messagesRead = getBy(messageId, chatType, userId);

        for (MessagesRead message : messagesRead) {
            if (message.getIsRead() == 0 || message.getIsRead() == 1) {
                message.setIsRead(2);
                message.setRead_at(LocalDateTime.now());
            }
        }

        readRepository.saveAll(messagesRead);
        return "Update success";

    }
}
