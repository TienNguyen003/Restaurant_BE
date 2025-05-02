package com.project.restaurantly.Service.chat;

import com.project.restaurantly.Entity.chat.PrivateChats;
import com.project.restaurantly.Exception.AppException;
import com.project.restaurantly.Exception.ErrorCode;
import com.project.restaurantly.Mapper.chat.PrivateChatsMapper;
import com.project.restaurantly.dto.request.chat.PrivateChatsRequest;
import com.project.restaurantly.dto.response.chat.PrivateChatsResponse;
import com.project.restaurantly.repository.chat.PrivateChatsRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PrivateChatsService {
    PrivateChatsRepository chatRepository;
    PrivateChatsMapper chatMapper;

    public PrivateChatsResponse create(PrivateChatsRequest request) {
        PrivateChats chat = chatMapper.toPrivateChats(request);

        chatRepository.save(chat);

        return chatMapper.toPrivateChatsResponse(chat);
    }

    public List<PrivateChatsResponse> getAll(int status) {
        var chat = chatRepository.findByStt(status);
        return chat.stream().map(chatMapper::toPrivateChatsResponse).toList();
    }

//    public List<PrivateChatsResponse> searchAll(String name, int pageNumber, int pageSize, int status) {
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

    public PrivateChatsResponse get(long id) {
        return chatMapper.toPrivateChatsResponse(chatRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.MENU_NOT_EXISTED)));
    }

    public PrivateChatsResponse update(PrivateChatsRequest request, long id) {
        PrivateChats chat = chatRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.MENU_NOT_EXISTED));

        chatMapper.updatePrivateChats(chat, request);

        return chatMapper.toPrivateChatsResponse(chatRepository.save(chat));
    }

    public void delete(long id) {
        PrivateChats chat = chatRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.MENU_NOT_EXISTED));
        chat.setStatus(0);
        chatRepository.save(chat);
    }
}
