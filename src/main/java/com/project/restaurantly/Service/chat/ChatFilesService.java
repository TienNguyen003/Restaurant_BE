package com.project.restaurantly.Service.chat;

import com.project.restaurantly.Entity.chat.ChatFiles;
import com.project.restaurantly.Exception.AppException;
import com.project.restaurantly.Exception.ErrorCode;
import com.project.restaurantly.Mapper.chat.ChatFilesMapper;
import com.project.restaurantly.dto.request.chat.ChatFilesRequest;
import com.project.restaurantly.dto.response.chat.ChatFilesResponse;
import com.project.restaurantly.repository.chat.ChatFilesRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ChatFilesService {
    ChatFilesRepository chatRepository;
    ChatFilesMapper chatMapper;

    public ChatFilesResponse create(ChatFilesRequest request) {
        ChatFiles chat = chatMapper.toChatFiles(request);

        chatRepository.save(chat);

        return chatMapper.toChatFilesResponse(chat);
    }

    public List<ChatFilesResponse> getAll(int status) {
        var permission = chatRepository.findByStt(status);
        return permission.stream().map(chatMapper::toChatFilesResponse).toList();
    }

//    public List<ChatFilesResponse> searchAll(String name, int pageNumber, int pageSize, int status) {
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

    public ChatFilesResponse get(long id) {
        return chatMapper.toChatFilesResponse(chatRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.MENU_NOT_EXISTED)));
    }

    public ChatFilesResponse update(ChatFilesRequest request, long id) {
        ChatFiles chat = chatRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.MENU_NOT_EXISTED));

        chatMapper.updateChatFiles(chat, request);

        return chatMapper.toChatFilesResponse(chatRepository.save(chat));
    }

    public void delete(long id) {
        ChatFiles chat = chatRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.MENU_NOT_EXISTED));
        chat.setStatus(0);
        chatRepository.save(chat);
    }
}
