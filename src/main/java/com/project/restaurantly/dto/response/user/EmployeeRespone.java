package com.project.restaurantly.dto.response.user;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeRespone {
    int id;
    String name;
    String email;
    String phone_number;
    String gender;
    String image;
    String birth_date;
    String joined_date;
    int shift_id;
    float vacationTime;
    int hourOff;
    int vacationHours;
    int timekeeping;
}
