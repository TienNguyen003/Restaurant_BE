package com.project.restaurantly.Entity.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.restaurantly.Entity.role.Role;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	String id;

	String username;

	@JsonIgnore
	String password;

	int status;

	@OneToOne
	Employee employee;

	@ManyToOne
	Role role;
}
