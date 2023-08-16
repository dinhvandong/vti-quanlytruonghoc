package com.vti.quanlytruonghoc.repositories;

import com.vti.quanlytruonghoc.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
