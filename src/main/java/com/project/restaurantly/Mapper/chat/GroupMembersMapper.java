package com.project.restaurantly.Mapper.chat;

import com.project.restaurantly.Entity.chat.GroupChatMember;
import com.project.restaurantly.dto.request.chat.GroupChatMemberRequest;
import com.project.restaurantly.dto.response.chat.GroupChatMemberResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface GroupMembersMapper {
    GroupChatMember toGroupChatMember(GroupChatMemberRequest request);

    GroupChatMemberResponse toGroupChatMemberResponse(GroupChatMember chat);

    void updateGroupChatMember(@MappingTarget GroupChatMember chat, GroupChatMemberRequest request);
}
