package com.project.restaurantly.dto.response.user;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserSessionResponse {
	long id;

	String userId;

	String deviceInfo;

	LocalDateTime loginAt;

	LocalDateTime logoutAt;

	int isLoggedIn;
}
