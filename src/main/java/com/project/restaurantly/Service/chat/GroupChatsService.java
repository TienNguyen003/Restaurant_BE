package com.project.restaurantly.Service.chat;

import com.project.restaurantly.Entity.chat.GroupChats;
import com.project.restaurantly.Exception.AppException;
import com.project.restaurantly.Exception.ErrorCode;
import com.project.restaurantly.Mapper.chat.GroupChatsMapper;
import com.project.restaurantly.dto.request.chat.GroupChatsRequest;
import com.project.restaurantly.dto.response.chat.GroupChatsResponse;
import com.project.restaurantly.repository.chat.GroupChatsRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class GroupChatsService {
    GroupChatsRepository chatRepository;
    GroupChatsMapper chatMapper;

    public GroupChatsResponse create(GroupChatsRequest request) {
        GroupChats chat = chatMapper.toGroupChats(request);

        chatRepository.save(chat);

        return chatMapper.toGroupChatsResponse(chat);
    }

    public List<GroupChatsResponse> getAll(int status) {
        var chats = chatRepository.findByStt(status);
        return chats.stream().map(chatMapper::toGroupChatsResponse).toList();
    }

//    public List<GroupChatsResponse> searchAll(String name, int pageNumber, int pageSize, int status) {
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

    public GroupChatsResponse get(long id) {
        return chatMapper.toGroupChatsResponse(chatRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.MENU_NOT_EXISTED)));
    }

    public GroupChatsResponse update(GroupChatsRequest request, long id) {
        GroupChats chat = chatRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.MENU_NOT_EXISTED));

        chatMapper.updateGroupChats(chat, request);

        return chatMapper.toGroupChatsResponse(chatRepository.save(chat));
    }

    public void delete(long id) {
        GroupChats chat = chatRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.MENU_NOT_EXISTED));
        chat.setStatus(0);
        chatRepository.save(chat);
    }
}
