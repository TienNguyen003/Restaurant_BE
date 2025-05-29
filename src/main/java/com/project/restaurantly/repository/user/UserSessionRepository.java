package com.project.restaurantly.repository.user;

import com.project.restaurantly.Entity.user.UserSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSessionRepository extends JpaRepository<UserSession, Long>{
	UserSession findByUserId(String userId);
}
