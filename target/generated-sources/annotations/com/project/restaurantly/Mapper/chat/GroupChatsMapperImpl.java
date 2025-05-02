package com.project.restaurantly.Mapper.chat;

import com.project.restaurantly.Entity.chat.GroupChats;
import com.project.restaurantly.dto.request.chat.GroupChatsRequest;
import com.project.restaurantly.dto.response.chat.GroupChatsResponse;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.3 (Oracle Corporation)"
)
@Component
public class GroupChatsMapperImpl implements GroupChatsMapper {

    @Override
    public GroupChats toGroupChats(GroupChatsRequest request) {
        if ( request == null ) {
            return null;
        }

        GroupChats.GroupChatsBuilder groupChats = GroupChats.builder();

        groupChats.groupName( request.getGroupName() );
        groupChats.createdAt( request.getCreatedAt() );
        groupChats.updatedAt( request.getUpdatedAt() );
        groupChats.status( request.getStatus() );

        return groupChats.build();
    }

    @Override
    public GroupChatsResponse toGroupChatsResponse(GroupChats chat) {
        if ( chat == null ) {
            return null;
        }

        GroupChatsResponse.GroupChatsResponseBuilder groupChatsResponse = GroupChatsResponse.builder();

        groupChatsResponse.id( chat.getId() );
        groupChatsResponse.groupName( chat.getGroupName() );
        groupChatsResponse.createdAt( chat.getCreatedAt() );
        groupChatsResponse.updatedAt( chat.getUpdatedAt() );
        groupChatsResponse.status( chat.getStatus() );

        return groupChatsResponse.build();
    }

    @Override
    public void updateGroupChats(GroupChats chat, GroupChatsRequest request) {
        if ( request == null ) {
            return;
        }

        chat.setGroupName( request.getGroupName() );
        chat.setCreatedAt( request.getCreatedAt() );
        chat.setUpdatedAt( request.getUpdatedAt() );
        chat.setStatus( request.getStatus() );
    }
}
