package com.project.restaurantly.Mapper.chat;

import com.project.restaurantly.Entity.chat.PrivateChats;
import com.project.restaurantly.dto.request.chat.PrivateChatsRequest;
import com.project.restaurantly.dto.response.chat.PrivateChatsResponse;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.3 (Oracle Corporation)"
)
@Component
public class PrivateChatsMapperImpl implements PrivateChatsMapper {

    @Override
    public PrivateChats toPrivateChats(PrivateChatsRequest request) {
        if ( request == null ) {
            return null;
        }

        PrivateChats.PrivateChatsBuilder privateChats = PrivateChats.builder();

        privateChats.createdAt( request.getCreatedAt() );
        privateChats.updatedAt( request.getUpdatedAt() );
        privateChats.status( request.getStatus() );

        return privateChats.build();
    }

    @Override
    public PrivateChatsResponse toPrivateChatsResponse(PrivateChats chat) {
        if ( chat == null ) {
            return null;
        }

        PrivateChatsResponse.PrivateChatsResponseBuilder privateChatsResponse = PrivateChatsResponse.builder();

        privateChatsResponse.id( chat.getId() );
        privateChatsResponse.userOneId( chat.getUserOneId() );
        privateChatsResponse.userTwoId( chat.getUserTwoId() );
        privateChatsResponse.createdAt( chat.getCreatedAt() );
        privateChatsResponse.updatedAt( chat.getUpdatedAt() );
        privateChatsResponse.status( chat.getStatus() );

        return privateChatsResponse.build();
    }

    @Override
    public void updatePrivateChats(PrivateChats chat, PrivateChatsRequest request) {
        if ( request == null ) {
            return;
        }

        chat.setCreatedAt( request.getCreatedAt() );
        chat.setUpdatedAt( request.getUpdatedAt() );
        chat.setStatus( request.getStatus() );
    }
}
