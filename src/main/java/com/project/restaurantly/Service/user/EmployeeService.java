package com.project.restaurantly.Service.user;

import com.project.restaurantly.Entity.user.Employee;
import com.project.restaurantly.Exception.AppException;
import com.project.restaurantly.Exception.ErrorCode;
import com.project.restaurantly.Mapper.user.EmployeeMapper;
import com.project.restaurantly.dto.request.user.employee.EmployeeRequest;
import com.project.restaurantly.dto.response.user.EmployeeRespone;
import com.project.restaurantly.repository.user.EmployeeRepository;
import com.project.restaurantly.repository.user.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EmployeeService {
    EmployeeMapper employeeMapper;
    EmployeeRepository employeeRepository;
    UserRepository userRepository;

    // thêm danh sách
    public EmployeeRespone createB(EmployeeRequest request, String username) {
        if(userRepository.existsByUsername(username))
            throw new AppException(ErrorCode.USERNAME_EXISTED);

        Employee employee = employeeMapper.toEmployee(request);

        return employeeMapper.toEmployeeRespone(employeeRepository.save(employee));
    }

    // cập nhật
    public EmployeeRespone updateB(int employeeId, EmployeeRequest request) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new AppException(ErrorCode.EMPLOYEE_NOT_EXISTED));

        employeeMapper.updateEmployee(employee, request);

        return employeeMapper.toEmployeeRespone(employeeRepository.save(employee));
    }

    // lấy ra tất cả
    public List<EmployeeRespone> getAllB(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
        return employeeRepository.findAll(pageable)
                .stream().map(employeeMapper::toEmployeeRespone).toList();
    }

    // lấy theo id
    public EmployeeRespone getById(int id) {
        return employeeMapper.toEmployeeRespone(employeeRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.EMPLOYEE_NOT_EXISTED)));
    }

    // xóa
    public void deleteB(int id) {
        employeeRepository.deleteById(id);
    }

}
