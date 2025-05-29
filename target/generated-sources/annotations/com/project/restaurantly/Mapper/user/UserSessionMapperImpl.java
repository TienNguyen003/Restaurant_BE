package com.project.restaurantly.Mapper.user;

import com.project.restaurantly.Entity.user.UserSession;
import com.project.restaurantly.dto.request.user.UserSessionRequest;
import com.project.restaurantly.dto.response.user.UserSessionResponse;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.3 (Oracle Corporation)"
)
@Component
public class UserSessionMapperImpl implements UserSessionMapper {

    @Override
    public UserSession toUserSession(UserSessionRequest request) {
        if ( request == null ) {
            return null;
        }

        UserSession.UserSessionBuilder userSession = UserSession.builder();

        userSession.userId( request.getUserId() );
        userSession.deviceInfo( request.getDeviceInfo() );
        userSession.loginAt( request.getLoginAt() );
        userSession.logoutAt( request.getLogoutAt() );
        userSession.isLoggedIn( request.getIsLoggedIn() );

        return userSession.build();
    }

    @Override
    public UserSessionResponse toUserSessionResponse(UserSession user) {
        if ( user == null ) {
            return null;
        }

        UserSessionResponse.UserSessionResponseBuilder userSessionResponse = UserSessionResponse.builder();

        userSessionResponse.id( user.getId() );
        userSessionResponse.userId( user.getUserId() );
        userSessionResponse.deviceInfo( user.getDeviceInfo() );
        userSessionResponse.loginAt( user.getLoginAt() );
        userSessionResponse.logoutAt( user.getLogoutAt() );
        userSessionResponse.isLoggedIn( user.getIsLoggedIn() );

        return userSessionResponse.build();
    }

    @Override
    public void updateUserSession(UserSession user, UserSessionRequest request) {
        if ( request == null ) {
            return;
        }

        user.setUserId( request.getUserId() );
        user.setDeviceInfo( request.getDeviceInfo() );
        user.setLoginAt( request.getLoginAt() );
        user.setLogoutAt( request.getLogoutAt() );
        user.setIsLoggedIn( request.getIsLoggedIn() );
    }
}
