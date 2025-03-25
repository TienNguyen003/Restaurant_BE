package com.project.restaurantly.Controller.user;

import com.project.restaurantly.Service.user.EmployeeService;
import com.project.restaurantly.dto.request.user.employee.EmployeeRequest;
import com.project.restaurantly.dto.response.ApiResponse;
import com.project.restaurantly.dto.response.user.EmployeeRespone;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.prefix}employee")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class EmployeeController {
	EmployeeService employeeService;

	@PreAuthorize("@requiredPermission.checkPermission('USER_ADD')")
	@PostMapping
	ApiResponse<EmployeeRespone> create(@RequestBody @Valid EmployeeRequest request, @RequestParam String username) {
		return ApiResponse.<EmployeeRespone>builder()
				.result(employeeService.createB(request, username))
				.build();
	}

	@PreAuthorize("@requiredPermission.checkPermission('USER_VIEW')")
	@GetMapping
	ApiResponse<List<EmployeeRespone>> getAll(@RequestParam("pageNumber") int pageNumber) {
		return ApiResponse.<List<EmployeeRespone>>builder()
				.result(employeeService.getAllB(pageNumber, 30))
				.build();
	}

	@GetMapping("/employee")
	ApiResponse<EmployeeRespone> getById(@RequestParam("id") int id) {
		return ApiResponse.<EmployeeRespone>builder()
				.result(employeeService.getById(id))
				.build();
	}

	@PreAuthorize("@requiredPermission.checkPermission('USER_EDIT')")
	@PutMapping
	ApiResponse<EmployeeRespone> update(@RequestParam int id,@RequestBody @Valid EmployeeRequest request) {
		return ApiResponse.<EmployeeRespone>builder()
				.result(employeeService.updateB(id, request))
				.build();
	}

	@PreAuthorize("@requiredPermission.checkPermission('USER_DELETE')")
	@DeleteMapping
	ApiResponse<String> delete (@RequestParam int id){
		employeeService.deleteB(id);
		return ApiResponse.<String>builder()
				.result("This employee has been deleted")
				.build();
	}
}
