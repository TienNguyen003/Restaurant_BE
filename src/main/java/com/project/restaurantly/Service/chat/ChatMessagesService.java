package com.project.restaurantly.Service.chat;

import com.project.restaurantly.Entity.chat.ChatMessages;
import com.project.restaurantly.Exception.AppException;
import com.project.restaurantly.Exception.ErrorCode;
import com.project.restaurantly.Mapper.chat.ChatMessagesMapper;
import com.project.restaurantly.dto.request.chat.ChatMessagesRequest;
import com.project.restaurantly.dto.request.chat.MessagesReadRequest;
import com.project.restaurantly.dto.response.chat.ChatMessagesResponse;
import com.project.restaurantly.dto.response.chat.PrivateChatsResponse;
import com.project.restaurantly.repository.chat.ChatMessagesRepository;
import com.project.restaurantly.repository.user.UserSessionRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ChatMessagesService {
    ChatMessagesRepository chatRepository;
    UserSessionRepository userSessionRepository;
    PrivateChatsService privateChatsService;
    MessagesReadService messagesReadService;
    ChatMessagesMapper chatMapper;

    public ChatMessagesResponse create(ChatMessagesRequest request) {
        ChatMessages chat = chatMapper.toChatMessages(request);
        PrivateChatsResponse privateChats = privateChatsService.getByChatId(request.getChatId());

        String receiverId = request.getSenderId().equals(privateChats.getUserTwoId().getId())
                ? privateChats.getUserOneId().getId()
                : privateChats.getUserTwoId().getId();

        boolean isReceiverOnline = userSessionRepository.findByUserId(receiverId) != null
                && userSessionRepository.findByUserId(receiverId).getIsLoggedIn() == 1;

        chatRepository.save(chat);

        MessagesReadRequest messagesRead = new MessagesReadRequest();
        messagesRead.setChatId(chat.getChatId());
        messagesRead.setChatType(0);
        messagesRead.setIsRead(isReceiverOnline ? 1 : 0);
        messagesRead.setRead_at(LocalDateTime.now());
        messagesRead.setUserId(receiverId);
        messagesRead.setMessageId(chat.getId());

        messagesReadService.create(messagesRead);

        return chatMapper.toChatMessagesResponse(chat);
    }


    public List<ChatMessagesResponse> getAll(int status) {
        var permission = chatRepository.findByStt(status);
        return permission.stream().map(chatMapper::toChatMessagesResponse).toList();
    }

//    public List<ChatMessagesResponse> searchAll(String name, int pageNumber, int pageSize, int status) {
//        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
//        return chatRepository.findByName(name, pageable, status)
//                .stream()
//                .map(chatMapper::toMenuRespone)
//                .toList();
//    }
//
//    public PageCustom getPagination(int pageNumber, int size, String name, int status) {
//        Pageable pageable = PageRequest.of(pageNumber - 1, size);
//        Page<Menu> page = chatRepository.findByName(name, pageable, status);
//        return PageCustom.builder()
//                .totalPages(String.valueOf(page.getTotalPages()))
//                .totalItems(String.valueOf(page.getTotalElements()))
//                .totalItemsPerPage(String.valueOf(page.getNumberOfElements()))
//                .currentPage(String.valueOf(pageNumber))
//                .build();
//    }

    public List<ChatMessagesResponse> get(int status, long chatId) {
        return chatRepository.findBySenderId(status, chatId).stream().map(chatMapper::toChatMessagesResponse).collect(Collectors.toList());
    }

    public ChatMessagesResponse update(ChatMessagesRequest request, long id) {
        ChatMessages chat = chatRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.MENU_NOT_EXISTED));

        chatMapper.updateChatMessages(chat, request);

        return chatMapper.toChatMessagesResponse(chatRepository.save(chat));
    }

    public void delete(long id) {
        ChatMessages chat = chatRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.MENU_NOT_EXISTED));
        chat.setStatus(0);
        chatRepository.save(chat);
    }
}
