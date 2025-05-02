package com.project.restaurantly.Service.chat;

import com.project.restaurantly.Entity.chat.GroupChatMember;
import com.project.restaurantly.Exception.AppException;
import com.project.restaurantly.Exception.ErrorCode;
import com.project.restaurantly.Mapper.chat.GroupMembersMapper;
import com.project.restaurantly.dto.request.chat.GroupChatMemberRequest;
import com.project.restaurantly.dto.response.chat.GroupChatMemberResponse;
import com.project.restaurantly.repository.chat.GroupMembersRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class GroupMembersService {
    GroupMembersRepository memberRepository;
    GroupMembersMapper memberMapper;

    public GroupChatMemberResponse create(GroupChatMemberRequest request) {
        GroupChatMember chat = memberMapper.toGroupChatMember(request);

        memberRepository.save(chat);

        return memberMapper.toGroupChatMemberResponse(chat);
    }

    public List<GroupChatMemberResponse> getAll() {
        return memberRepository.findAll().stream().map(memberMapper::toGroupChatMemberResponse).toList();
    }

//    public List<GroupChatMemberResponse> searchAll(String name, int pageNumber, int pageSize, int status) {
//        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
//        return memberRepository.findByName(name, pageable, status)
//                .stream()
//                .map(memberMapper::toMenuRespone)
//                .toList();
//    }
//
//    public PageCustom getPagination(int pageNumber, int size, String name, int status) {
//        Pageable pageable = PageRequest.of(pageNumber - 1, size);
//        Page<Menu> page = memberRepository.findByName(name, pageable, status);
//        return PageCustom.builder()
//                .totalPages(String.valueOf(page.getTotalPages()))
//                .totalItems(String.valueOf(page.getTotalElements()))
//                .totalItemsPerPage(String.valueOf(page.getNumberOfElements()))
//                .currentPage(String.valueOf(pageNumber))
//                .build();
//    }

    public GroupChatMemberResponse get(long id) {
        return memberMapper.toGroupChatMemberResponse(memberRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.MENU_NOT_EXISTED)));
    }

    public GroupChatMemberResponse update(GroupChatMemberRequest request, long id) {
        GroupChatMember chat = memberRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.MENU_NOT_EXISTED));

        memberMapper.updateGroupChatMember(chat, request);

        return memberMapper.toGroupChatMemberResponse(memberRepository.save(chat));
    }

    public void delete(long id) {
        memberRepository.deleteById(id);
    }
}
