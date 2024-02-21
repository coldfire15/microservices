package com.ammouri.school.clients;

import com.ammouri.school.Student;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "student-service", url = "${application.config.students-url}")
public interface StudentClient {
  @GetMapping(value = "/school/{school-id}")
  List<Student> findAllStudentsBySchool(@PathVariable("school-id") Long schoolId);


}
