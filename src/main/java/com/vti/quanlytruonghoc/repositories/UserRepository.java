package com.vti.quanlytruonghoc.repositories;

import com.vti.quanlytruonghoc.models.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository  extends JpaRepository<User, Long> {
    @EntityGraph(attributePaths = {"userProfile"})
    List<User> findAll();
}
