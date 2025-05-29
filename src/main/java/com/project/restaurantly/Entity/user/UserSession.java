package com.project.restaurantly.Entity.user;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserSession {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;

	String userId;

	String deviceInfo; // nếu bạn muốn hỗ trợ đa thiết bị

	LocalDateTime loginAt;

	LocalDateTime logoutAt;

	int isLoggedIn;
}
