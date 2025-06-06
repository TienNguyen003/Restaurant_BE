package com.project.restaurantly.Service.chat;

import com.project.restaurantly.Entity.chat.UserChatMeta;
import com.project.restaurantly.Exception.AppException;
import com.project.restaurantly.Exception.ErrorCode;
import com.project.restaurantly.Mapper.chat.UserChatMetaMapper;
import com.project.restaurantly.dto.request.chat.UserChatMetaRequest;
import com.project.restaurantly.dto.response.chat.UserChatMetaResponse;
import com.project.restaurantly.repository.chat.UserChatMetaRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserChatMetaService {
    UserChatMetaRepository metaRepository;
    UserChatMetaMapper metaMapper;

    public UserChatMetaResponse create(UserChatMetaRequest request) {
        UserChatMeta chatMeta = metaRepository.findByChatIdAndUserId(request.getChatId(), request.getUserId());

        if (chatMeta == null) {
            chatMeta = metaMapper.toUserChatMeta(request);
        } else {
            if(request.getLastSeenAt() != null) chatMeta.setLastSeenAt(request.getLastSeenAt());
            else {
                chatMeta.setLastTimeMessage(request.getLastTimeMessage());
                chatMeta.setUnreadCount(chatMeta.getUnreadCount() + 1);
            }
        }

        metaRepository.save(chatMeta);

        return metaMapper.toUserChatMetaResponse(chatMeta);
    }

    public List<UserChatMetaResponse> getAll() {
        return metaRepository.findAll().stream().map(metaMapper::toUserChatMetaResponse).toList();
    }

//    public List<UserChatMetaResponse> searchAll(String name, int pageNumber, int pageSize, int status) {
//        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
//        return metaRepository.findByName(name, pageable, status)
//                .stream()
//                .map(metaMapper::toMenuRespone)
//                .toList();
//    }
//
//    public PageCustom getPagination(int pageNumber, int size, String name, int status) {
//        Pageable pageable = PageRequest.of(pageNumber - 1, size);
//        Page<Menu> page = metaRepository.findByName(name, pageable, status);
//        return PageCustom.builder()
//                .totalPages(String.valueOf(page.getTotalPages()))
//                .totalItems(String.valueOf(page.getTotalElements()))
//                .totalItemsPerPage(String.valueOf(page.getNumberOfElements()))
//                .currentPage(String.valueOf(pageNumber))
//                .build();
//    }

    public List<UserChatMetaResponse> get(long chatId, String userId, int chatType) {
        return metaRepository.findByChatId(chatId, userId, chatType).stream().map(metaMapper::toUserChatMetaResponse).collect(Collectors.toList());
    }

    public UserChatMetaResponse update(UserChatMetaRequest request, long id) {
        UserChatMeta meta = metaRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.MENU_NOT_EXISTED));

        metaMapper.updateUserChatMeta(meta, request);

        return metaMapper.toUserChatMetaResponse(metaRepository.save(meta));
    }

    public void delete(long id) {
        metaRepository.deleteById(id);
    }
}
