package com.project.restaurantly.Service.user;

import com.project.restaurantly.Entity.user.UserSession;
import com.project.restaurantly.Exception.AppException;
import com.project.restaurantly.Exception.ErrorCode;
import com.project.restaurantly.Mapper.user.UserSessionMapper;
import com.project.restaurantly.dto.request.user.UserSessionRequest;
import com.project.restaurantly.dto.response.user.UserSessionResponse;
import com.project.restaurantly.repository.user.UserSessionRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserSessionService {
	UserSessionRepository userSessionRepository;
	UserSessionMapper userSessionMapper;
	
	public UserSessionResponse createUser(UserSessionRequest request) {
		UserSession user = userSessionRepository.findByUserId(request.getUserId());

		if(user == null) user = userSessionMapper.toUserSession(request);
		else updateUser(user.getId(), request);
		
		return userSessionMapper.toUserSessionResponse(userSessionRepository.save(user));
	}

	public List<UserSessionResponse> getAll(){
		return userSessionRepository.findAll().stream().map(userSessionMapper::toUserSessionResponse).toList();
	}

	public UserSessionResponse getUser(long id) {
		return userSessionMapper.toUserSessionResponse(userSessionRepository.findById(id)
				.orElseThrow(() -> new AppException(ErrorCode.USERNAME_NOT_EXISTED)));
	}
	
	public UserSessionResponse updateUser(long id, UserSessionRequest request) {
		UserSession user = userSessionRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.USERNAME_NOT_EXISTED));

		userSessionMapper.updateUserSession(user, request);
		
		return userSessionMapper.toUserSessionResponse(userSessionRepository.save(user));
	}
	
	public void deleteUser(long id) {
		userSessionRepository.deleteById(id);
	}
}
