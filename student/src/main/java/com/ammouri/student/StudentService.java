package com.ammouri.student;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class StudentService {
  private final StudentDao repository;

  public Student saveStudent(Student student){
    log.warn("The user is saved");
    return repository.save(student);
  }

  public List<Student> findAllStudents(){
    return repository.findAll();
  }

  public List<Student> findAllBySchool(Long schoolId) {
    return this.repository.findAllStudentsBySchoolId(schoolId);
  }

  public List<Student> findAllStudentsBySchoolId(Long schoolId) {
    log.warn("Student Service: Find all students by school id");
    return this.repository.findAllStudentsBySchoolId(schoolId);
  }
}
