package com.ammouri.school;

import com.ammouri.school.clients.StudentClient;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
//@RequiredArgsConstructor
public class SchoolService {

  private final SchoolDao repository;
  private final StudentClient studentClient;

  public SchoolService(SchoolDao repository, StudentClient studentClient) {
    this.repository = repository;
    this.studentClient = studentClient;
  }

  public School saveSchool(School school) {
    return repository.save(school);
  }

  public List<School> findAllSchools() {
    return repository.findAll();
  }

  public FullSchoolResponse findSchoolsWithStudents(Long schoolId) {
    log.warn("SchoolService: findSchoolWithStudents");
    var school = this.repository.findById(schoolId)
        .orElse(School.builder()
            .email("NOT FOUND")
            .name("NOT FOUND")
            .build());
    var students = this.studentClient.findAllStudentsBySchool(schoolId);
    return FullSchoolResponse.builder()
        .name(school.getName())
        .email(school.getEmail())
        .students(students)
        .build();

  }
}
