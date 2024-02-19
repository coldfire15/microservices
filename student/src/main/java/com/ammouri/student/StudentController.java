package com.ammouri.student;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/api/v1/students")
@RequiredArgsConstructor
public class StudentController {

  private final StudentService service;
  @PostMapping(value = "/save")
  public ResponseEntity<?> saveStudent(@RequestBody Student student){
    return  ResponseEntity.ok(service.saveStudent(student));
  }

  @GetMapping(value = "/getall")
  public ResponseEntity<List<Student>> getAllStudents(){
    return ResponseEntity.ok(service.findAllStudents());
  }
  @GetMapping(value = "/school/{school-id}")
  public ResponseEntity<List<Student>> schoolWithStudents(@PathVariable("school-id") Long schoolId){
    return ResponseEntity.ok(this.service.findAllStudentsBySchoolId(schoolId));
  }

}
