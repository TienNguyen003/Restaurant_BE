package com.project.restaurantly.Mapper.user;

import com.project.restaurantly.Entity.user.Employee;
import com.project.restaurantly.dto.request.user.employee.EmployeeRequest;
import com.project.restaurantly.dto.response.user.EmployeeRespone;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    Employee toEmployee(EmployeeRequest request);

    EmployeeRespone toEmployeeRespone(Employee employee);

    void updateEmployee(@MappingTarget Employee employee, EmployeeRequest request);
}
