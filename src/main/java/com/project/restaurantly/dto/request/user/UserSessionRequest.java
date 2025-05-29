package com.project.restaurantly.dto.request.user;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserSessionRequest {
	String userId;

	String deviceInfo;

	LocalDateTime loginAt;

	LocalDateTime logoutAt;

	int isLoggedIn;
}
