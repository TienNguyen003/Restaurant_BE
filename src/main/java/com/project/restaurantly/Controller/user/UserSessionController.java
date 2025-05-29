package com.project.restaurantly.Controller.user;

import com.project.restaurantly.Service.user.UserSessionService;
import com.project.restaurantly.dto.request.user.UserSessionRequest;
import com.project.restaurantly.dto.response.ApiResponse;
import com.project.restaurantly.dto.response.user.UserSessionResponse;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.prefix}user-session")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class UserSessionController {
	UserSessionService sessionService;

//	@PreAuthorize("@requiredPermission.checkPermission('USER_ADD')")
	@PostMapping
	ApiResponse<UserSessionResponse> create(@RequestBody @Valid UserSessionRequest request) {
		return ApiResponse.<UserSessionResponse>builder()
				.result(sessionService.createUser(request))
				.build();
	}

//	@PreAuthorize("@requiredPermission.checkPermission('USER_VIEW')")
	@GetMapping
	ApiResponse<List<UserSessionResponse>> getAll() {
		return ApiResponse.<List<UserSessionResponse>>builder()
				.result(sessionService.getAll())
				.build();
	}

	@GetMapping("/by")
	ApiResponse<UserSessionResponse> getById(@RequestParam("id") int id) {
		return ApiResponse.<UserSessionResponse>builder()
				.result(sessionService.getUser(id))
				.build();
	}

//	@PreAuthorize("@requiredPermission.checkPermission('USER_EDIT')")
	@PutMapping
	ApiResponse<UserSessionResponse> update(@RequestParam int id, @RequestBody @Valid UserSessionRequest request) {
		return ApiResponse.<UserSessionResponse>builder()
				.result(sessionService.updateUser(id, request))
				.build();
	}

//	@PreAuthorize("@requiredPermission.checkPermission('USER_DELETE')")
	@DeleteMapping
	ApiResponse<String> delete (@RequestParam long id){
		sessionService.deleteUser(id);
		return ApiResponse.<String>builder()
				.result("This user session has been deleted")
				.build();
	}
}
