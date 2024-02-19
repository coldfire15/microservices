package com.ammouri.student;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDao extends JpaRepository<Student,Long> {

  List<Student> findAllStudentsBySchoolId(Long schoolId);
}
