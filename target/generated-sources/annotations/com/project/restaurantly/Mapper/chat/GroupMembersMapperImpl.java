package com.project.restaurantly.Mapper.chat;

import com.project.restaurantly.Entity.chat.GroupChatMember;
import com.project.restaurantly.dto.request.chat.GroupChatMemberRequest;
import com.project.restaurantly.dto.response.chat.GroupChatMemberResponse;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.3 (Oracle Corporation)"
)
@Component
public class GroupMembersMapperImpl implements GroupMembersMapper {

    @Override
    public GroupChatMember toGroupChatMember(GroupChatMemberRequest request) {
        if ( request == null ) {
            return null;
        }

        GroupChatMember.GroupChatMemberBuilder groupChatMember = GroupChatMember.builder();

        groupChatMember.userId( request.getUserId() );
        groupChatMember.groupChatId( request.getGroupChatId() );

        return groupChatMember.build();
    }

    @Override
    public GroupChatMemberResponse toGroupChatMemberResponse(GroupChatMember chat) {
        if ( chat == null ) {
            return null;
        }

        GroupChatMemberResponse.GroupChatMemberResponseBuilder groupChatMemberResponse = GroupChatMemberResponse.builder();

        groupChatMemberResponse.id( chat.getId() );
        groupChatMemberResponse.userId( chat.getUserId() );
        groupChatMemberResponse.groupChatId( chat.getGroupChatId() );

        return groupChatMemberResponse.build();
    }

    @Override
    public void updateGroupChatMember(GroupChatMember chat, GroupChatMemberRequest request) {
        if ( request == null ) {
            return;
        }

        chat.setUserId( request.getUserId() );
        chat.setGroupChatId( request.getGroupChatId() );
    }
}
