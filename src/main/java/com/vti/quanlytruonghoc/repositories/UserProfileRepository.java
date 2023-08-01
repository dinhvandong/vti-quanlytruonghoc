package com.vti.quanlytruonghoc.repositories;

import com.vti.quanlytruonghoc.models.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
}
